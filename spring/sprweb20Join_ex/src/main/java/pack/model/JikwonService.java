package pack.model;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JikwonService {

    @Autowired
    private JikwonRepository jikwonRepository;

    public List<Jikwon> getJikwonAll() {
        return jikwonRepository.findAll();
    }

    public Jikwon getJikwonByNo(int jikwonno) {
        return jikwonRepository.findById(jikwonno).orElse(null);
    }
}
