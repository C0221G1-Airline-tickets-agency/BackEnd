package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;
import com.backend.airline_tickets_agency_management.model.service.customer.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;
    @GetMapping("/customer/list")
    public Page<Customer> ShowPageCustomer(@RequestParam(defaultValue = "0") int page){
        return iCustomerService.showListCustomer(PageRequest.of(page,5));
    }
    @GetMapping("/customer/search")
    public Page<Customer> searchPageCustomer(@RequestParam(defaultValue = "0") int page ,
                                             @RequestParam Optional<String> field,
                                             @RequestParam Optional<String> search){
        String fieldSearch = "";
        String valueSearch = "";
        if (field.isPresent()){
            fieldSearch = field.get();
        }
        if (search.isPresent()){
            valueSearch = search.get();
        }
        return iCustomerService.searchPageCustomer(PageRequest.of(page,5), fieldSearch, valueSearch);
    }
    @PatchMapping("/customer/delete")
    public void DeleteCustomer(@RequestBody Customer customer){
        customer.setFlag(false);
        iCustomerService.saveCustomer(customer);
    }
}
