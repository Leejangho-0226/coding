package pack.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pack.model.Springboard;

public interface SpringboardRepository extends JpaRepository<Springboard, Integer> {
    // 기본 CRUD (등록, 수정, 삭제, 조회) 자동 제공
}
