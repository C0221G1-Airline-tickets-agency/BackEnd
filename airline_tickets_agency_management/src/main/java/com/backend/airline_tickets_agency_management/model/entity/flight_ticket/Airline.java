package com.backend.airline_tickets_agency_management.model.entity.flight_ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "airline")
public class Airline {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "airline_id")
    private Long airlineId;
    private String airlineName;
    private String logo;


    @OneToMany(mappedBy = "airline")
    @JsonBackReference
    private List<Flight> flights;
}
