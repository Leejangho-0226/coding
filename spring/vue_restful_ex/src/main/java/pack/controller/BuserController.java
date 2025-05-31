package pack.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pack.dto.BuserDto;
import pack.dto.JikwonDto;
import pack.service.BuserService;

@RestController
@RequestMapping("/dept")
public class BuserController {

    @Autowired
    private BuserService buserService;

    // ✅ 부서 전체 조회
    @GetMapping
    public List<BuserDto> listAll() {
        return buserService.getAll();
    }

    // ✅ 부서 하나 조회
    @GetMapping("/{id}")
    public BuserDto getOne(@PathVariable("id") int id) {
        return buserService.getById(id);
    }

    // ✅ 부서 등록
    @PostMapping
    public void addDept(@RequestBody BuserDto dto) {
        buserService.insert(dto);
    }

    // ✅ 부서 수정
    @PutMapping("/{id}")
    public void updateDept(@PathVariable("id") int id, @RequestBody BuserDto dto) {
        dto.setBuserno(id);
        buserService.update(dto);
    }

    // ✅ 부서 삭제
    @DeleteMapping("/{id}")
    public void deleteDept(@PathVariable("id") int id) {
        buserService.delete(id);
    }

    // ✅ 기존: 부서번호로 소속 직원 조회
    @GetMapping("/{id}/jikwon")
    public List<JikwonDto> getDeptJikwons(@PathVariable("id") int id) {
        return buserService.getJikwonList(id);
    }

    // ✅ 추가: 전체 직원 + 부서명 조회
    @GetMapping("/all-jikwon-grouped")
    public List<JikwonDto> getAllJikwonWithBuser() {
        return buserService.getAllJikwonWithBuser();
    }
}
