package pack.business;

import java.util.List;
import org.springframework.stereotype.Service;
import pack.model.DataDao;
import pack.model.JikwonDto;

@Service
public class BusinessImpl implements BusinessInter {
    private DataDao dao = new DataDao();

    @Override
    public void dataPrint() {
        System.out.println(" 직원 목록 (사번 / 이름 / 부서명 / 입사년)");
        System.out.println("-------------------------------------------");
        List<JikwonDto> list = dao.getJikwonList();
        for (JikwonDto dto : list) {
            System.out.println(dto.getJikwonno() + " / "
                             + dto.getJikwonname() + " / "
                             + dto.getBusername() + " / "
                             + dto.getIbsayear());
        }

        System.out.println("\n 부서별 인원수");
        System.out.println("------------------------");
        List<JikwonDto> buserList = dao.getBuserCount();
        for (JikwonDto dto : buserList) {
            System.out.println(dto.getBusername() + " : " + dto.getCnt());
        }

        System.out.println("\n 부서별 최대 급여자");
        System.out.println("------------------------");
        List<JikwonDto> maxList = dao.getMaxPayByBuser();
        for (JikwonDto dto : maxList) {
            System.out.println(dto.getBusername() + " : "
                             + dto.getJikwonname() + "("
                             + dto.getJikwonpay() + ")");
        }
    }
}
