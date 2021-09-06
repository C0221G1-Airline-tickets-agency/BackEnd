package com.backend.airline_tickets_agency_management.model.service.ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import com.backend.airline_tickets_agency_management.model.service.IGeneralService;

import java.util.List;

public interface ITicketService extends IGeneralService<Ticket> {
    public List<Ticket> findAll();
}
