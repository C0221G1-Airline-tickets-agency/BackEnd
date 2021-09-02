package com.backend.airline_tickets_agency_management.model.entity.customer;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
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
    private Integer customerEmail;
    private String customerPhone;
    private String gender;
    private String birthday;
    private String nationality;
    private String image;
    private Boolean flag;
    @OneToMany(mappedBy = "customer")
    @JsonBackReference
    private List<Ticket> tickets;

}
