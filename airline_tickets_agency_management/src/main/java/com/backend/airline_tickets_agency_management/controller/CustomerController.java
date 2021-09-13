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
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
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
    public Map<String,Object> createCustomer(@Valid @RequestBody CustomerDto customerDto,
                                             BindingResult bindingResult) {
      return this.iCustomerService.createCustomer(customerDto,bindingResult);
    }

    @PutMapping("/update/{id}")
    public Map<String, Object> updateCustomer(@PathVariable Long id, @Valid @RequestBody CustomerDto customerDto,
                                                   BindingResult bindingResult) {
        return this.iCustomerService.updateCustomer(id,customerDto,bindingResult);
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
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(
//            MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach(error -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }

}
