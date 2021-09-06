package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import com.backend.airline_tickets_agency_management.model.service.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/ticket")
public class TicketController {
    @Autowired
    ITicketService ticketService;

    @GetMapping(" ")
    public ResponseEntity<List<Ticket>> showDrugGroup() {
        List<Ticket> tickets = ticketService.findAll();
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(tickets, HttpStatus.OK);
        }
    }

    @PutMapping(value = "/edit/{ticketId}")
    public ResponseEntity<Ticket> update(@PathVariable Long ticketId, @RequestBody Ticket ticket) {
        Optional <Ticket> ticketObj = ticketService.findById(ticketId);
        if (ticket == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        ticketObj.get().setPassengerName(ticket.getPassengerName());
        ticketObj.get().setPassengerEmail(ticket.getPassengerEmail());
        ticketService.save(ticketObj.get());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
