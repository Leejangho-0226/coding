package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "jikwon")
public class Jikwon {
    @Id
    private int jikwonno;
    private String jikwonname;
    private String jikwonjik;
    private int busernum;
}
