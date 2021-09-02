package com.backend.airline_tickets_agency_management.model.repository.employee;
import com.backend.airline_tickets_agency_management.model.entity.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Long> {
}
