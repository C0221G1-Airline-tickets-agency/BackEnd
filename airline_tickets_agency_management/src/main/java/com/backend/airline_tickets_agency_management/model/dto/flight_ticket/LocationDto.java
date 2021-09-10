package com.backend.airline_tickets_agency_management.model.dto.flight_ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Flight;

import java.util.List;

public class LocationDto {
    private Long locationId;
    private String cityName;
    private String airportName;
    private String areaCode;
    List<Flight> flightsTo;
    List<Flight> flightsFrom;
    public LocationDto() {
        // no args
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
    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
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
