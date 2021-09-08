package com.backend.airline_tickets_agency_management.model.entity.flight_ticket;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;
    private String cityName;
    private String airportName;
    private String areaCode;

    @OneToMany(mappedBy = "locationTo")
    @JsonIgnore
    List<Flight> flightsTo;

    @OneToMany(mappedBy = "locationFrom")
    @JsonIgnore
    List<Flight> flightsFrom;

}
