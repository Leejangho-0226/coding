package pack.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pack.dto.BuserDto;
import pack.dto.JikwonDto;
import pack.mapper.MainMapper;

@Service
public class MainService {

    @Autowired
    private MainMapper mapper;

    public List<BuserDto> allBuser() {
        return mapper.selectAllBuser();
    }

    public List<JikwonDto> allJikwon() {
        return mapper.selectAllJikwon();
    }

    public List<JikwonDto> jikwonByBuser(String buser_name) {
        return mapper.selectJikwonByBuser(buser_name);
    }
}
