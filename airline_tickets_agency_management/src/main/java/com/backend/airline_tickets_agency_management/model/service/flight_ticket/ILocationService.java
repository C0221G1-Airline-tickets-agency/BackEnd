package com.backend.airline_tickets_agency_management.model.service.flight_ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Location;

import java.util.List;

public interface ILocationService {
    List<Location> findAll();
}
