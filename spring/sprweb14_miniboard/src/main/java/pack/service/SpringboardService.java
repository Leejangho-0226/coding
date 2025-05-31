package pack.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pack.model.Springboard;
import pack.model.SpringboardBean;
import pack.repository.SpringboardRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SpringboardService {

    private final SpringboardRepository repository;

    // 전체 글 조회
    public List<Springboard> getAll() {
        return repository.findAll();
    }

    // 글 등록
    public String savePost(SpringboardBean bean) {
        try {
            Springboard board = Springboard.builder()
                    .author(bean.getAuthor())
                    .title(bean.getTitle())
                    .content(bean.getContent())
                    .bwrite(LocalDateTime.now())
                    .readcnt(0)
                    .build();
            repository.save(board);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    // 글 상세 조회
    public Springboard getOne(int num) {
        return repository.findById(num).orElse(null);
    }

    // 글 수정
    public String update(SpringboardBean bean) {
        try {
            Springboard existing = repository.findById(bean.getNum()).orElse(null);
            if (existing == null) return "fail";

            existing.setAuthor(bean.getAuthor());
            existing.setTitle(bean.getTitle());
            existing.setContent(bean.getContent());
            repository.save(existing);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    // 글 삭제
    public String delete(int num) {
        try {
            repository.deleteById(num);
            return "success";
        } catch (Exception e) {
            return "fail";
        }
    }

    // ✅ 조회수 증가
    public void increaseReadCount(int num) {
        Springboard board = repository.findById(num).orElse(null);
        if (board != null) {
            board.setReadcnt(board.getReadcnt() + 1);
            repository.save(board);
        }
    }
}
