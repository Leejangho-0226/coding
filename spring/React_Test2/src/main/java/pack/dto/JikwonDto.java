package pack.dto;

import lombok.Data;

@Data
public class JikwonDto {
    private int jikwonno;         // 사번
    private String jikwonname;    // 이름
    private String busername;     // 부서명 (조인된 값)
    private String jik;           // 직급
    private int gogekcount;       // 관리고객 수
    private int jikwonpay;        // 연봉
}
