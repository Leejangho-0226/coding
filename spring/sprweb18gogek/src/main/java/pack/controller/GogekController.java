package pack.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import pack.model.DataProcess;
import pack.model.GogekDto;

@Controller
public class GogekController {

    @Autowired
    private DataProcess dataProcess;

   
    @GetMapping("/")
    public String index() {
        return "index";  
    }

    
    @GetMapping("/list")
    public String showList(GogekBean bean, Model model) {
        String gender = bean.getGender();  // 전체, 남, 여 값 받음
        List<GogekDto> list = dataProcess.getGogekList(gender);  // 필터링된 DTO 리스트

        model.addAttribute("list", list);       // 고객 리스트 전달
        model.addAttribute("count", list.size()); // 인원수 전달
        model.addAttribute("gender", gender);   // 현재 선택된 성별 전달 

        return "list";  
    }
}
