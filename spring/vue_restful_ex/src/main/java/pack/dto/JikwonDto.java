package pack.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Alias("jikwon")
public class JikwonDto {
    private int jikwonno;
    private String jikwonname;
    private String jikwonjik;
    private int busernum;
    private String busername; // ✅ 부서명 추가
}
