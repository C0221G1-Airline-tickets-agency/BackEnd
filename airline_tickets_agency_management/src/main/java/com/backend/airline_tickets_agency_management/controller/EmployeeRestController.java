package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.entity.employee.Employee;
import com.backend.airline_tickets_agency_management.model.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/employee")
public class EmployeeRestController {
    @Autowired
    private IEmployeeService employeeService;

    @GetMapping("/{id}")
    public ResponseEntity findEmployee(@PathVariable Long id) {
        Employee employee = employeeService.findById(id).orElse(null);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }
}
