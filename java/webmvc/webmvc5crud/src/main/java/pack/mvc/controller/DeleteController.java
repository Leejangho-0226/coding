package pack.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import pack.mvc.model.ProcessManager;

public class DeleteController implements Controller {
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		request.setCharacterEncoding("utf-8");
		String userid = request.getParameter("userid");

		// 모델과 통신
		int re = ProcessManager.instance().delete(userid);

		ModelAndView modelAndView = new ModelAndView();
		if (re > 0) {
			modelAndView.setViewName("list.m2"); // 삭제 후 회원보기
		} else {
			modelAndView.setViewName("fail.html");
		}
		modelAndView.setRedirect(true);
		return modelAndView;

	}
}
