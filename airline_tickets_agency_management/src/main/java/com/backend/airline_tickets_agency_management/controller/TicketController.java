package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.dto.flight_ticket.TicketDto;
import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import com.backend.airline_tickets_agency_management.model.service.flight_ticket.ticket.ITicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
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
    public ResponseEntity<Ticket> update(@PathVariable Long ticketId, @Valid @RequestBody TicketDto ticketDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        if (ticketDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        ticketDto.setTicketId(ticketId);
        Ticket ticket= new Ticket();
        BeanUtils.copyProperties(ticketDto,ticket);
        ticketService.save(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
