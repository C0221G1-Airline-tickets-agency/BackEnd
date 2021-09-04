package com.backend.airline_tickets_agency_management.model.entity.flight_ticket;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long flightId;
    private String flightCode;
    private String flightDate;
    private String departureTime;
    private String endTime;
    private Boolean flag = true;


    @ManyToOne
    @JoinColumn(name = "airline_id",referencedColumnName = "airline_id")
    private Airline airline;

    @OneToMany(mappedBy = "flight")
    @JsonBackReference
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "point_of_departure",referencedColumnName = "location_id")
    private Location locationTo;

    @ManyToOne
    @JoinColumn(name = "destination",referencedColumnName = "location_id")
    private Location locationFrom;

    public Flight() {
    }

    public Flight(Long flightId, String flightCode, String flightDate, String departureTime, String endTime, Boolean flag, Airline airline, List<Ticket> tickets, Location locationTo, Location locationFrom) {
        this.flightId = flightId;
        this.flightCode = flightCode;
        this.flightDate = flightDate;
        this.departureTime = departureTime;
        this.endTime = endTime;
        this.flag = flag;
        this.airline = airline;
        this.tickets = tickets;
        this.locationTo = locationTo;
        this.locationFrom = locationFrom;
    }

    public Long getFlightId() {
        return flightId;
    }

    public void setFlightId(Long flightId) {
        this.flightId = flightId;
    }

    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
    }

    public String getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(String flightDate) {
        this.flightDate = flightDate;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public Boolean isFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Location getLocationTo() {
        return locationTo;
    }

    public void setLocationTo(Location locationTo) {
        this.locationTo = locationTo;
    }

    public Location getLocationFrom() {
        return locationFrom;
    }

    public void setLocationFrom(Location locationFrom) {
        this.locationFrom = locationFrom;
    }
}
