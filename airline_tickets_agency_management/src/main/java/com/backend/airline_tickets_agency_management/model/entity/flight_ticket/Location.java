package com.backend.airline_tickets_agency_management.model.entity.flight_ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id")
    private Long locationId;
    private String cityName;
    private String airportName;

    @OneToMany(mappedBy = "locationTo")
    @JsonBackReference(value = "flightsTo_Flight")
    List<Flight> flightsTo;

    @OneToMany(mappedBy = "locationFrom")
    @JsonBackReference(value = "flightsFrom_Flight")
    List<Flight> flightsFrom;

    public Location() {
    }

    public Location(Long locationId, String cityName, String airportName, List<Flight> flightsTo, List<Flight> flightsFrom) {
        this.locationId = locationId;
        this.cityName = cityName;
        this.airportName = airportName;
        this.flightsTo = flightsTo;
        this.flightsFrom = flightsFrom;
    }

    public Long getLocationId() {
        return locationId;
    }

    public void setLocationId(Long locationId) {
        this.locationId = locationId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public List<Flight> getFlightsTo() {
        return flightsTo;
    }

    public void setFlightsTo(List<Flight> flightsTo) {
        this.flightsTo = flightsTo;
    }

    public List<Flight> getFlightsFrom() {
        return flightsFrom;
    }

    public void setFlightsFrom(List<Flight> flightsFrom) {
        this.flightsFrom = flightsFrom;
    }
}
