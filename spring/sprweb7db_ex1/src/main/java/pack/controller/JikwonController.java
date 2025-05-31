package pack.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam; 

import pack.model.JikwonDao;
import pack.model.JikwonDto;

@Controller
public class JikwonController {

    @Autowired
    private JikwonDao dao;

    @GetMapping("/")
    public String formPage() {
        return "index";
    }

    @GetMapping("/search")
    public String searchProcess(@RequestParam("jik") String jik, Model model) {
        ArrayList<JikwonDto> list = dao.getListByJik(jik);
        if (!list.isEmpty()) {
            model.addAttribute("datas", list);
            model.addAttribute("cnt", list.size());
        }

        return "list";
    }
}
