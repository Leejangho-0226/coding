package pack.model;

import lombok.Data;

@Data
public class JikwonDto {
    private int jikwonno;
    private String jikwonname;
    private Integer busernum;
    private String jikwonjik;
    private int jikwonpay;
    private String jikwonibsail;
    private String jikwongen;
    private String jikwonrating;

    private String busername; // 부서명
    private String ibsayear;  // 입사년도
    private int cnt;          // 부서별 인원수
}
