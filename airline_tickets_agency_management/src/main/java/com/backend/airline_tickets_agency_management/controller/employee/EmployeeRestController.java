package com.backend.airline_tickets_agency_management.controller.employee;

import com.backend.airline_tickets_agency_management.model.dto.employee.IEmployeeDto;
import com.backend.airline_tickets_agency_management.model.entity.employee.Employee;
import com.backend.airline_tickets_agency_management.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
@CrossOrigin(origins = "http://localhost:4200/")
public class EmployeeRestController {
    @Autowired
    IEmployeeService service;

    @GetMapping("/list")
    public ResponseEntity<Page<IEmployeeDto>> getList(@RequestParam Optional<String> typeSearch,
                                                      @RequestParam Optional<String> valueSearch,
                                                      @RequestParam Optional<Integer> page) {
        String check = typeSearch.orElse("");
        if ("".equals(check)) check = "employee_code";
        Page<IEmployeeDto> employeeList = service.getAllEmployee(check, valueSearch.orElse(""), page.orElse(0));
        if (employeeList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        Employee employee = service.findById(id).orElse(null);
        if (employee == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        employee.setFlag(false);
        service.save(employee);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
