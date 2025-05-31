package pack;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pack.good.DataVo;

@Controller // 객체 생성. 사용자의 요청을 처리한 후 지정된 view 에 모델 객체를 넘겨주는 역할
public class TestController {

	@RequestMapping("test1") // 클라이언트의 요청과 매핑 - 내부에서 viewResolver 수행
	public ModelAndView abc() {
		String msg = "첫번째 요청 처리 성공"; // Model을 통해 경과를 얻었다고 가정
		
		/*
		 * ModelAndView modelAndView = new ModelAndView();
		 * modelAndView.setViewName("list"); modelAndView.addObject("msg" , msg); //
		 * request.setAttribute("msg",msg) return modelAndView;
		 */

		return new ModelAndView("list", "msg", msg);
	}

	@RequestMapping(value = "test2", method = RequestMethod.GET) // get방식만 post방식으로 부르면 못만남
	public ModelAndView abc2() {
		return new ModelAndView("list", "msg", "성공2");
	}

	// @RequestMapping(value = "test3") // get방식만, 1개만 받을때
	@GetMapping(value = { "test3", "testgood", "nice" }) // 여러개 받을때 사용
	public ModelAndView abc3() {
		return new ModelAndView("list", "msg", "성공3");
	}

	@GetMapping("test4")
	public String abc4(Model model) {
		model.addAttribute("msg", "성공4");
		return "list"; // 파일명
	}

	@RequestMapping(value = "test5", method = RequestMethod.POST) // index에서 메소드가 get이면 오류 나옴
	public ModelAndView abc5() {
		return new ModelAndView("list", "msg", "성공5");
	}

	@PostMapping("test6")
	public ModelAndView abc6() {
		return new ModelAndView("list", "msg", "성공6");
	}

	@PostMapping("test7")
	public String abc7(Model model) {
		model.addAttribute("msg", "성공7");
		return "list";
	}

	@GetMapping("test8")
	@ResponseBody
	public String abc8() {
		String value = "일반 데이터-String, map, JSON 등을 전달";
		return value;

	}
	
	
	@GetMapping("test8_1")
	@ResponseBody
	public DataVo abc8_1() {
		DataVo dataVo = new DataVo();
		dataVo.setCode(10);
		dataVo.setName("한국인");
		
		return dataVo;

	}
	
	@GetMapping("test8_2")
	@ResponseBody
	public List<DataVo> abc8_2() {
		List<DataVo> list = new ArrayList<DataVo>();
		for(int i=1; i <= 5; i++) {
			DataVo dataVo = new DataVo();
			dataVo.setCode(10);
			dataVo.setName("한국인" + i);
			list.add(dataVo);
		}
		
		return list;

	}

}