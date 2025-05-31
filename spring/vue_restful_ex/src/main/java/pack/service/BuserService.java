package pack.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.dto.BuserDto;
import pack.dto.JikwonDto;
import pack.mybatis.DeptMapper;

@Service
public class BuserService {

    @Autowired
    private DeptMapper deptMapper;

    public List<BuserDto> getAll() {
        return deptMapper.getAllBuser();
    }

    public BuserDto getById(int buserno) {
        return deptMapper.getBuserById(buserno);
    }

    public void insert(BuserDto dto) {
        deptMapper.insertBuser(dto);
    }

    public void update(BuserDto dto) {
        deptMapper.updateBuser(dto);
    }

    public void delete(int buserno) {
        deptMapper.deleteBuser(buserno);
    }

    public List<JikwonDto> getJikwonList(int buserno) {
        return deptMapper.getJikwonByBuser(buserno);
    }

    // ✅ 전체 직원 + 부서명 포함 조회 추가
    public List<JikwonDto> getAllJikwonWithBuser() {
        return deptMapper.getAllJikwonWithBuser();
    }
}
