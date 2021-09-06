package com.backend.airline_tickets_agency_management.model.service.ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import com.backend.airline_tickets_agency_management.model.repository.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketService  implements ITicketService{
    @Autowired
    TicketRepository ticketRepository;
    @Override
    public Page findAllWithKeyWord(Pageable pageable, String keyword) {
        return null;
    }
    public List<Ticket> findAll() {
        return ticketRepository.findAll();
    }

    @Override
    public Optional findById(Long id) {
        return ticketRepository.findById(id);
    }

    @Override
    public List findAllNormal() {
        return null;
    }

    @Override
    public void save(Ticket ticket) {
        ticketRepository.save(ticket);
    }


    @Override
    public void remove(Long id) {

    }
}
