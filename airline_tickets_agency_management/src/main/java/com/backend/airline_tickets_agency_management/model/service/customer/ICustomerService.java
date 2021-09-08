package com.backend.airline_tickets_agency_management.model.service.customer;


import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;

import java.util.List;

public interface ICustomerService {
    Customer findCustomerById(Long id);

    void insertCustomer(String address, String birthday, String code, String email, String gender, String name, String nationality, String phone, Boolean flag, String passport);

    List<Customer> findAllNormal();
}
