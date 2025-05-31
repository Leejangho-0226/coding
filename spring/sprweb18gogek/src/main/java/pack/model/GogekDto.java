package pack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor         
@AllArgsConstructor        
public class GogekDto {
    private int gogekno;         
    private String gogekname;    
    private String gogektel;     
    private String gogekjumin;   
    private int gogekdamsano;    
    private String gender;       
    private int age;             

    public static GogekDto fromEntity(Gogek gogek) {
        String jumin = gogek.getGogekjumin();            // 주민번호
        char code = jumin.charAt(7);                     // 7번째 자리 성별 코드

        // 성별: 홀수 → 남 / 짝수 → 여
        String gender = (code % 2 == 1) ? "남" : "여";

        // 출생년도 앞자리: 1,2 → 1900년대 / 3,4 → 2000년대
        String yearPrefix = (code <= '2') ? "19" : "20";
        int birthYear = Integer.parseInt(yearPrefix + jumin.substring(0, 2));
        int currentYear = java.time.LocalDate.now().getYear();
        int age = currentYear - birthYear;

        return GogekDto.builder()
                .gogekno(gogek.getGogekno())
                .gogekname(gogek.getGogekname())
                .gogektel(gogek.getGogektel())
                .gogekjumin(gogek.getGogekjumin())
                .gogekdamsano(gogek.getGogekdamsano())
                .gender(gender)
                .age(age)
                .build();
    }
}
