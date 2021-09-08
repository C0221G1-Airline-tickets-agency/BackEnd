package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.dto.customer.CustomerDto;
import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;
import com.backend.airline_tickets_agency_management.model.service.customer.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "api/customer")
public class CustomerController {
    @Autowired
    ICustomerService iCustomerService;

    @GetMapping("/list")
    public Page<Customer> ShowPageCustomer(@RequestParam(defaultValue = "0") int page) {
        return iCustomerService.showListCustomer(PageRequest.of(page, 5));
    }

    @GetMapping("/search")
    public Page<Customer> searchPageCustomer(@RequestParam(defaultValue = "0") int page,
                                             @RequestParam Optional<String> field,
                                             @RequestParam Optional<String> search) {
        String fieldSearch = "";
        String valueSearch = "";
        if (field.isPresent()) {
            fieldSearch = field.get();
        }
        if (search.isPresent()) {
            valueSearch = search.get();
        }
        return iCustomerService.searchPageCustomer(PageRequest.of(page, 5), fieldSearch, valueSearch);
    }

    @PatchMapping("/delete")
    public void DeleteCustomer(@RequestBody Customer customer) {
        customer.setFlag(false);
        iCustomerService.saveCustomer(customer);
    }

    //Toàn code
    @PostMapping("/create")
    public ResponseEntity<Customer> createCustomer(@Valid @RequestBody CustomerDto customerDto,
                                                   BindingResult bindingResult) {
        Customer customer = new Customer();
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerDto.setFlag(true);
            BeanUtils.copyProperties(customerDto, customer);
            return new ResponseEntity<>(this.iCustomerService.saveCustomer(customer), HttpStatus.OK);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Customer> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDto customerDto,
                                                   BindingResult bindingResult) {
        Customer customer = this.iCustomerService.findCustomerById(id);
        if (customer == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Customer customer1 = new Customer();
        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            customerDto.setCustomerId(customer.getCustomerId());
            BeanUtils.copyProperties(customerDto, customer1);
            return new ResponseEntity<>(this.iCustomerService.updateCustomer(customer1), HttpStatus.OK);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Customer> findById(@PathVariable Long id){
        Customer customer = this.iCustomerService.findCustomerById(id);
        if (customer == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }else {
            return new ResponseEntity<>(customer,HttpStatus.OK);
        }
    }

}
