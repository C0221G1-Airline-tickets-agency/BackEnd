package com.backend.airline_tickets_agency_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class AirlineTicketsAgencyManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(AirlineTicketsAgencyManagementApplication.class, args);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        bCryptPasswordEncoder.encode("123123");
        System.out.println( bCryptPasswordEncoder.encode("123123"));
    }

}
