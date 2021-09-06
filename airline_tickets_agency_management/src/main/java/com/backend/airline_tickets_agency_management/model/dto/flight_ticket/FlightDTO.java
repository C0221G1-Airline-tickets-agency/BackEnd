package com.backend.airline_tickets_agency_management.model.dto.flight_ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Airline;
import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Location;
import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;

import java.util.List;

public class FlightDTO {
    private Long flightId;
    private String flightCode;
    private String flightDate;
    private String departureTime;
    private String endTime;
    private Boolean flag = true;
    private Airline airline;
    private List<Ticket> tickets;
    private Location locationTo;
    private Location locationFrom;
}
