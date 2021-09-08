package com.backend.airline_tickets_agency_management.model.repository.customer;

import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    @Query(value = "select * from customer where customer_id = ?1",nativeQuery = true)
    Customer findCustomerById(Long id);

    @Modifying
    @Transactional
    @Query(value="INSERT INTO `customer` (`customer_address`, `customer_birthday`, `customer_code`, `customer_email`, `customer_gender`, `customer_name`, `customer_nationality`, `customer_phone`, `flag`, `customer_passport`) VALUES (?1,?2,?3,?4,?5,?6,?7,?8,?9,?10)",
    nativeQuery = true)
    void insertCustomer(String address, String birthday, String code, String email, String gender, String name, String nationality, String phone, Boolean flag, String passport);

    @Query(value = "select * from customer ",nativeQuery = true)
    List<Customer> findAllNormal();
}
