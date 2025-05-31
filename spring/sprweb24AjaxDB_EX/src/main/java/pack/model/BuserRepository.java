package pack.model;

import org.springframework.data.repository.Repository;

public interface BuserRepository extends Repository<Buser, Integer> {
    Buser findByBuserno(int no);
}
