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
          return iCustomerRepository.searchCustomerByCode("%" + search + "%", pageable);
      }
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        List<Customer> customerList = this.iCustomerRepository.findAllNormal();
        String code = "";
        if (customerList.isEmpty()) {
            code = "KH001";
        }else {
            Long lastId = customerList.get(customerList.size() - 1).getCustomerId();
            if (lastId < 10) {
                code = "KH00" + (lastId + 1);
            } else if (lastId < 100) {
                code = "KH0" + (lastId + 1);
            }
        }
        customer.setCustomerCode(code);
        return iCustomerRepository.save(customer);
    }

    @Override
    public Customer findCustomerById(Long id) {
        return this.iCustomerRepository.findCustomerById(id);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
       return this.iCustomerRepository.save(customer);
    }
}
