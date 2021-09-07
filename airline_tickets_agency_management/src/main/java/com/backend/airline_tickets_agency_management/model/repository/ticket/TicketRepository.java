package com.backend.airline_tickets_agency_management.model.repository.ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket,Long> {
}
