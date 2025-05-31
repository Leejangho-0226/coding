package pack.service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import pack.dto.CustomerDto;
import pack.dto.EmployeeRequest;

@Service
public class CustomerService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public boolean checkEmployeeValid(EmployeeRequest req) {
        String sql = "SELECT COUNT(*) FROM jikwon WHERE jikwonno = ? AND jikwonname = ?";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class, req.getSabun(), req.getIrum());
        return count != null && count > 0;
    }

    public List<CustomerDto> getCustomers(EmployeeRequest req) {
        String sql = "SELECT gogekno, gogekname, gogektel FROM gogek WHERE gogekdamsano = ?";
        List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql, req.getSabun());

        return rows.stream()
                   .map(row -> new CustomerDto(
                       (int) row.get("gogekno"),
                       (String) row.get("gogekname"),
                       (String) row.get("gogektel")
                   ))
                   .collect(Collectors.toList());
    }
}
