package pack.model;

import org.springframework.data.repository.Repository;

public interface JikwonRepository extends Repository<Jikwon, Integer> {
    Jikwon findByJikwonno(int no);
}
