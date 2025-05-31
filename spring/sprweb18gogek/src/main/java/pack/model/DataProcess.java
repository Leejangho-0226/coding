package pack.model;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class DataProcess {
    @Autowired
    private GogekRepository repository;

    public List<GogekDto> getGogekList(String gender) {
        List<Gogek> list = repository.findAll();

        return list.stream()
                .map(GogekDto::fromEntity)
                .filter(dto -> {
                    if (gender.equals("all")) return true;
                    return dto.getGender().equals(gender);
                })
                .collect(Collectors.toList());
    }
}
