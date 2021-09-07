package com.backend.airline_tickets_agency_management.model.service.customer;

import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> showListCustomer(Pageable pageable);

    Page<Customer> searchPageCustomer(Pageable pageable, String field, String search);

    void saveCustomer(Customer customer);
}
