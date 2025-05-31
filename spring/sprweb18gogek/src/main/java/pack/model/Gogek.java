package pack.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gogek")
public class Gogek {
    @Id
    private int gogekno;

    private String gogekname;
    private String gogektel;
    private String gogekjumin;
    private int gogekdamsano;
}
