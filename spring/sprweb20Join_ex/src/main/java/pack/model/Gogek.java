package pack.model;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class Gogek {
    @Id
    private int gogekno;
    private String gogekname;
    private String gogektel;
    private String gogekjumin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "gogekdamsano")
    private Jikwon jikwon;

    // 성별 반환
    public String getGender() {
        if (gogekjumin == null || gogekjumin.length() < 7) return "알수없음";
        return (gogekjumin.charAt(6) % 2 == 1) ? "남자" : "여자";
    }

    public int getAge() {
        if (gogekjumin == null || gogekjumin.length() < 7) return 0;
        int year = Integer.parseInt(gogekjumin.substring(0, 2));
        int prefix = (gogekjumin.charAt(6) < '3') ? 1900 : 2000;
        int birthYear = prefix + year;
        return java.time.Year.now().getValue() - birthYear + 1;
    }
}
