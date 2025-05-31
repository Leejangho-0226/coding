package pack.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pack.dto.BuserDto;
import pack.dto.JikwonDto;
import pack.service.MainService;

@RestController
@RequestMapping("/api")
public class MainController {

    @Autowired
    private MainService service;

    // ✅ 구구단: 단 입력 시 결과 반환
    @GetMapping("/gugu")
    public Map<String, List<String>> gugudan(@RequestParam("dan") int dan) {
        List<String> result = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            result.add(dan + " * " + i + " = " + (dan * i));
        }
        return Map.of("result", result);
    }

    // ✅ 부서 전체 조회
    @GetMapping("/buser")
    public List<BuserDto> buser() {
        return service.allBuser();
    }

    // ✅ 직원 전체 조회 or 부서명 필터 조회
    @GetMapping("/jikwon")
    public List<JikwonDto> jikwonAll(@RequestParam(value = "buser", required = false) String buser) {
        if (buser == null || buser.isBlank()) {
            return service.allJikwon();
        } else {
            return service.jikwonByBuser(buser);
        }
    }
}
