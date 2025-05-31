package pack.dto;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Alias("jikDto")
public class JikwonDto {
    private int jikwonno;
    private String jikwonname;
    private String jik;
    private int jikwonyears;
    private int jikwonpay;
    private String jikwonsex;
}
