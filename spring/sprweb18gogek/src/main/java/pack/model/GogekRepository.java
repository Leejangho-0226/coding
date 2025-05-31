package pack.model;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GogekRepository extends JpaRepository<Gogek, Integer> {
    // 별도 메서드 불필요, 전체 다 조회해서 Service에서 성별 판별
}
