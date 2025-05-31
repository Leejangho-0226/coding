package pack.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pack.dto.CustomerDto;
import pack.dto.EmployeeRequest;
import pack.service.CustomerService;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @PostMapping("/checkEmployee")
    public Map<String, Boolean> checkEmployee(@RequestBody EmployeeRequest req) {
        boolean valid = service.checkEmployeeValid(req);
        Map<String, Boolean> result = new HashMap<>();
        result.put("valid", valid);
        return result;
    }

    @PostMapping("/getCustomers")
    public List<CustomerDto> getCustomers(@RequestBody EmployeeRequest req) {
        return service.getCustomers(req);
    }
}
