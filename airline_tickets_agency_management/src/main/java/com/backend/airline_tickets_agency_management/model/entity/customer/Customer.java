package com.backend.airline_tickets_agency_management.model.entity.customer;
import com.backend.airline_tickets_agency_management.model.entity.user.User;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "customer")
@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customerId;
    private String customerCode;
    private String customerName;
    private String customerEmail;
    private String customerPhone;
    private String customerGender;
    private String customerBirthday;
    private String customerNationality;
    private String customerImage;
    private String customerAddress;
    private String customerPassport;
    private Boolean flag = true;
    @OneToOne(mappedBy = "customer")
    @JsonBackReference
    private User user;
}
