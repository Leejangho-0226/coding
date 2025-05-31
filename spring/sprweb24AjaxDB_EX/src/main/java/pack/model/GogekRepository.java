package pack.model;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

public interface GogekRepository extends Repository<Gogek, Integer> {
    @Query("SELECT g.gogekdamsano FROM Gogek g WHERE g.gogekno = :no AND g.gogekname = :name")
    Integer findDamsano(@Param("no") int gogekno, @Param("name") String gogekname);
}
