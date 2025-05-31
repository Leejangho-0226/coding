package pack.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataDao {
    @Autowired
    private GogekRepository gogekRepository;
    @Autowired
    private JikwonRepository jikwonRepository;
    @Autowired
    private BuserRepository buserRepository;

    public JikwonDto getManager(int gogekno, String gogekname) {
        Integer jikwonno = gogekRepository.findDamsano(gogekno, gogekname);
        if (jikwonno == null) return null;

        Jikwon j = jikwonRepository.findByJikwonno(jikwonno);
        Buser b = buserRepository.findByBuserno(j.getBusernum());

        return JikwonDto.builder()
                .jikwonname(j.getJikwonname())
                .jikwonjik(j.getJikwonjik())
                .busername(b.getBusername())
                .busertel(b.getBusertel())
                .build();
    }
}
