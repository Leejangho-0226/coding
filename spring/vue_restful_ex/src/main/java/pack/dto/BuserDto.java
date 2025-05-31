package pack.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import org.apache.ibatis.type.Alias;

@Data                       // getter/setter, toString 등 자동 생성
@NoArgsConstructor          // 기본 생성자
@AllArgsConstructor         // 전체 필드 생성자
@Alias("buser")             // MyBatis 별칭 등록
public class BuserDto {
    private int buserno;
    private String busername;
    private String buserloc;
    private String busertel;
}
