package pack.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import pack.dto.BuserDto;
import pack.dto.JikwonDto;

@Mapper
public interface MainMapper {
    List<BuserDto> selectAllBuser();                 // 부서 전체 조회
    List<JikwonDto> selectAllJikwon();               // 전체 직원 조회
    List<JikwonDto> selectJikwonByBuser(String buser_name); // 부서명 필터 직원 조회
}
