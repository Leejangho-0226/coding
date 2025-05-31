package pack.mybatis;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import pack.dto.BuserDto;
import pack.dto.JikwonDto;

@Mapper
public interface DeptMapper {
    List<BuserDto> getAllBuser();
    BuserDto getBuserById(int buserno);
    void insertBuser(BuserDto dto);
    void updateBuser(BuserDto dto);
    void deleteBuser(int buserno);
    List<JikwonDto> getJikwonByBuser(int buserno);

    // ✅ 전체 직원 + 부서명 포함 조회
    List<JikwonDto> getAllJikwonWithBuser();
}
