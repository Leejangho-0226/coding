package pack.mvc.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import pack.mvc.model.ProcessManager;

public class LoginController implements Controller{
	@Override
	public ModelAndView execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		String id = request.getParameter("userid");
		String password = request.getParameter("password");
		// System.out.println(id + " " + password);
		
		// 모델과 통신
		boolean b = ProcessManager.instance().login(id, password);
		
		ModelAndView modelAndView = new ModelAndView();
		if(b) { // 로그인 성공
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("userid", id); // 세션 생성
			modelAndView.setViewName("list.m2");
		}else { // 로그인 실패
			modelAndView.setViewName("fail.html");
		}
		modelAndView.setRedirect(true);
		return modelAndView;
	}
}
