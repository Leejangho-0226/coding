package pack.model;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Buser {
    @Id
    private int buserno;
    private String busername;
    private String busertel;

    @OneToMany(mappedBy = "buser")
    private List<Jikwon> jikwons;
}
