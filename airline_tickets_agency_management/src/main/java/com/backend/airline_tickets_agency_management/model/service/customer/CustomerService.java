package com.backend.airline_tickets_agency_management.model.service.customer;

import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;
import com.backend.airline_tickets_agency_management.model.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;

    @Override
    public Customer findCustomerById(Long id) {
        return this.iCustomerRepository.findCustomerById(id);
    }

    @Override
    public void insertCustomer(String address, String birthday, String code, String email, String gender, String name, String nationality, String phone, Boolean flag, String passport) {
        this.iCustomerRepository.insertCustomer(address, birthday, code, email, gender, name, nationality, phone, flag, passport);
    }

    @Override
    public List<Customer> findAllNormal() {
        return this.iCustomerRepository.findAllNormal();
    }
}
