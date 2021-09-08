package com.backend.airline_tickets_agency_management.model.service.customer;

import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;
import com.backend.airline_tickets_agency_management.model.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService {
    @Autowired
    ICustomerRepository iCustomerRepository;
    @Override
    public Page<Customer> showListCustomer(Pageable pageable) {
        return iCustomerRepository.findAll(pageable);
    }

    @Override
    public Page<Customer> searchPageCustomer(Pageable pageable, String fieldSearch, String search) {
      if ("name".equals(fieldSearch)){
          return iCustomerRepository.searchCustomerByName("%" + search + "%", pageable);
      } else if("email".equals(fieldSearch)){
          return iCustomerRepository.searchCustomerByEmail("%" + search + "%", pageable);
      }else {
          return iCustomerRepository.searchCustomerByBirthday("%" + search + "%", pageable);
      }
    }

    @Override
    public void saveCustomer(Customer customer) {
        iCustomerRepository.save(customer);
    }
}
