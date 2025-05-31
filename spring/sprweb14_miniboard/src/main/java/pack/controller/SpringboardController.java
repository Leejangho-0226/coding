package pack.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pack.model.Springboard;
import pack.model.SpringboardBean;
import pack.service.SpringboardService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class SpringboardController {

    private final SpringboardService service;

    // 홈 화면
    @GetMapping("/")
    public String main() {
        return "index";
    }

    // 글 목록
    @GetMapping("/list")
    public String list(Model model) {
        List<Springboard> list = service.getAll();
        model.addAttribute("list", list); // list.html에서 ${list}로 받음
        return "list";
    }

    // 글쓰기 폼
    @GetMapping("/insert")
    public String insertForm(Model model) {
        model.addAttribute("springboardBean", new SpringboardBean());
        return "insertform";
    }

    // 글 등록 처리
    @PostMapping("/insert")
    public String insertProcess(@ModelAttribute SpringboardBean bean, Model model) {
        String msg = service.savePost(bean);
        if ("success".equals(msg)) {
            return "redirect:/list";
        } else {
            model.addAttribute("msg", msg);
            return "error";
        }
    }

    // 상세보기 (+ 조회수 증가)
    @GetMapping("/detail")
    public String detail(@RequestParam("num") int num, Model model) {
        service.increaseReadCount(num); // 조회수 증가
        Springboard data = service.getOne(num);
        model.addAttribute("data", data);
        return "detail";
    }

    // 수정 폼
    @GetMapping("/update")
    public String updateForm(@RequestParam("num") int num, Model model) {
        Springboard data = service.getOne(num);
        model.addAttribute("data", data);
        return "updateform";
    }

    // 수정 처리
    @PostMapping("/update")
    public String updateProcess(@ModelAttribute SpringboardBean bean, Model model) {
        String msg = service.update(bean);
        if ("success".equals(msg)) {
            return "redirect:/list";
        } else {
            model.addAttribute("msg", msg);
            return "error";
        }
    }

    // 삭제 처리
    @GetMapping("/delete")
    public String delete(@RequestParam("num") int num, Model model) {
        String msg = service.delete(num);
        if ("success".equals(msg)) {
            return "redirect:/list";
        } else {
            model.addAttribute("msg", msg);
            return "error";
        }
    }
}
