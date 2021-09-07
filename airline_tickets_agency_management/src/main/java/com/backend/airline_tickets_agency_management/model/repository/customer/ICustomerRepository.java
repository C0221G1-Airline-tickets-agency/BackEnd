package com.backend.airline_tickets_agency_management.model.repository.customer;

import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    @Query(value = "select * from customer where flag = true " ,nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);

    @Query(value = "{call searchCustomer(?1,?2)}", nativeQuery = true)
    List<Customer> search(String field, String search);

    @Query(value = "select * from customer where customer_name like ?1 and  flag = true " ,nativeQuery = true)
    Page<Customer> searchCustomerByName( String search, Pageable pageable);
    @Query(value = "select * from customer where customer_email like:keyword and  flag = true " ,nativeQuery = true)
    Page<Customer> searchCustomerByEmail(@Param("keyword") String search, Pageable pageable);
    @Query(value = "select * from customer where customer_code like ?1 and  flag = true " ,nativeQuery = true)
    Page<Customer> searchCustomerByCode( String search, Pageable pageable);

    //Toàn code
    @Query(value = "select * from customer ",nativeQuery = true)
    List<Customer> findAllNormal();

    @Query(value = "select * from customer where customer_id = ?1",nativeQuery = true)
    Customer findCustomerById(Long id);
}
