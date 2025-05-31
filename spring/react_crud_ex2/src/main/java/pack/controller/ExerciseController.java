package pack.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pack.dto.ExerciseDto;
import pack.entity.Exercise;
import pack.repository.ExerciseRepository;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    @Autowired
    private ExerciseRepository repo;

    // 전체 조회
    @GetMapping
    public List<ExerciseDto> list() {
        return repo.findAll().stream().map(e -> ExerciseDto.builder()
                .id(e.getId())
                .name(e.getName())
                .duration(e.getDuration())
                .calorieburn(e.getCalorieburn())
                .build()
        ).collect(Collectors.toList());
    }

    // 등록
    @PostMapping
    public void insert(@RequestBody ExerciseDto dto) {
        int calorie = (int)(0.05 * 70 * dto.getDuration());
        repo.save(Exercise.builder()
                .name(dto.getName())
                .duration(dto.getDuration())
                .calorieburn(calorie)
                .build());
    }

    // 수정
    @PutMapping("/{id}")
    public void update(@PathVariable Long id, @RequestBody ExerciseDto dto) {
        Exercise ex = repo.findById(id).orElseThrow();
        ex.setName(dto.getName());
        ex.setDuration(dto.getDuration());
        int calorie = (int)(0.05 * 70 * dto.getDuration());
        ex.setCalorieburn(calorie);
        repo.save(ex);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        repo.deleteById(id);
    }

    // 단건 조회 (수정용)
    @GetMapping("/{id}")
    public ExerciseDto getOne(@PathVariable Long id) {
        Exercise e = repo.findById(id).orElseThrow();
        return ExerciseDto.builder()
                .id(e.getId())
                .name(e.getName())
                .duration(e.getDuration())
                .calorieburn(e.getCalorieburn())
                .build();
    }
}
