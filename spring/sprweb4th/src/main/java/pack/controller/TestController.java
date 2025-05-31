package pack.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	@GetMapping("thymeleaftest")
	public String sijak(Model model) {
		model.addAttribute("msg", "타임리프 만세");
		model.addAttribute("msg2", "염인선");
		
		// DTO 타입 자료 출력
		Sangpum sangpum = new Sangpum();
		sangpum.setCode("10");
		sangpum.setSang("카페라떼");
		sangpum.setPrice("3500");
		model.addAttribute("sangpum", sangpum);
		
		// 컬렉션 자료 출력 
		 ArrayList<Sangpum> list = new ArrayList<Sangpum>();
	        list.add(sangpum);
	        Sangpum sangpum2 = new Sangpum();
	        sangpum2.setCode("20");
	        sangpum2.setSang("아메리카노");
	        sangpum2.setPrice("2000");
	        list.add(sangpum2);

	        model.addAttribute("list", list);
		
		return "list1";
	}
}
