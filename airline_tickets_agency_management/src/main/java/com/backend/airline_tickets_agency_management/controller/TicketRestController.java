package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import com.backend.airline_tickets_agency_management.model.service.flight_ticket.ticket.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/tickets")
public class TicketRestController {
    @Autowired
    private ITicketService ticketService;

    @GetMapping(value = "/ticket-list")
    public ResponseEntity<Page<Ticket>> findTicketsByFilter(@RequestParam Optional<Integer> filterType,
                                                            @RequestParam Optional<String> keySearch,
                                                            @RequestParam Optional<Integer> page) {
        Pageable pageable = PageRequest.of(page.orElse(0), 5);
        String[] keys = {"","","",""};
        if(keySearch.isPresent()){
            keys[filterType.orElse(0)] = keySearch.get();
        }
        Page<Ticket> ticketPage = this.ticketService.findAllByFilter(keys[0],keys[1],keys[2],keys[3],pageable);
        if(ticketPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketPage, HttpStatus.OK);
    }
    @DeleteMapping(value = "ticket-delete/{id}")
    public ResponseEntity<Ticket> deleteTicketById(@PathVariable Long id){
        Ticket ticket = this.ticketService.findById(id).orElse(null);
        if(ticket == null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        this.ticketService.remove(id);
        return new ResponseEntity<>(ticket,HttpStatus.OK);
    }
}
