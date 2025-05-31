package pack.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MappingController {
	@GetMapping(value = "kbs/login", params = "type=admin")
	public String aaa(Model model) {
		model.addAttribute("message", "관리자");
		return "list";
	}
	
	@GetMapping(value = "kbs/login", params = "type=user")
	public String aaa2(Model model) {
		model.addAttribute("message", "일반 고객");
		return "list";
	}
	
	@GetMapping(value = "kbs/login", params = "!type")
	public String aaa3(Model model) {
		model.addAttribute("message", "type 값이 없어용");
		return "list";
	}
	
	@PostMapping(value = "kbs/login")
	public String aaa4(Model model, @RequestParam("type")String type) {
//		model.addAttribute("message", "type : " + type);
//		return "list";
		
		if(type.equals("user")) {
			model.addAttribute("message", type);
		}else if(type.equals("admin")) {
			model.addAttribute("message", "관리자군요");
		}else {
			model.addAttribute("message", "기타");
		}
		return "list";
	}
	
//	ent/hive/singer/bts?title=다이너마이트
	@GetMapping(value = "ent/{co}/singer/{singer}")  //정적
	public String aaa5(Model model,
			@RequestParam("title")String title,  //동적
			@PathVariable("co")String co,
			@PathVariable("singer")String singetName) {
		String ss = "소속사 : " + co + ", 가수 : " + singetName + ", 노래제목 : " + title;
		
		model.addAttribute("message", ss);
		return "list";
	}
}
