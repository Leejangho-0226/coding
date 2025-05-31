package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pack.model.DataDao;
import pack.model.JikwonDto;

@Controller
public class AjaxController {
    @Autowired
    private DataDao dao;

    @GetMapping("/findManager")
    public String find(@RequestParam(value="gogekno", required=false) Integer gogekno,
                       @RequestParam(value="gogekname", required=false) String gogekname,
                       Model model) {
        // ✅ 서버에서도 빈값 검사
        if (gogekno == null || gogekname == null || gogekname.trim().isEmpty()) {
            model.addAttribute("error", "고객번호와 고객명을 모두 입력해주세요.");
            return "index";  // 다시 index.html로
        }

        JikwonDto dto = dao.getManager(gogekno, gogekname);
        model.addAttribute("dto", dto);
        return "list";  // 정상 이동
    }
}
