package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pack.model.Jikwon;
import pack.model.JikwonService;

@Controller
public class JikwonController {

    @Autowired
    private JikwonService service;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/jikwonlist")
    public String showEmployeeList(Model model) {
        model.addAttribute("emplist", service.getJikwonAll());
        return "list";
    }

    @GetMapping("/customerlist")
    public String showCustomerList(@RequestParam("jikwonno") int jikwonno, Model model) {
        Jikwon jikwon = service.getJikwonByNo(jikwonno);
        model.addAttribute("gogeklist", jikwon.getGogeks());
        model.addAttribute("jikwonname", jikwon.getJikwonname());
        model.addAttribute("jikwonjik", jikwon.getJikwonjik());
        return "customerlist";
    }
}
