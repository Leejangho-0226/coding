package pack.dto;

import lombok.Data;

@Data
public class BuserDto {
    private int buserno;         // 부서 번호
    private String busername;    // 부서명
    private String busertel;     // 부서 전화
    private int count;           // 근무 인원 수 (서브쿼리 계산)
}
