package com.backend.airline_tickets_agency_management.controller.flight_ticket.ticket;

import com.backend.airline_tickets_agency_management.model.dto.flight_ticket.TicketDto;
import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import com.backend.airline_tickets_agency_management.model.service.flight_ticket.ticket.ITicketService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
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
    @PutMapping(value = "ticket-edit/{id}")
    public ResponseEntity<Ticket> update(@PathVariable Long id, @Valid @RequestBody TicketDto ticketDto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        if (ticketDto == null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        if (ticketDto.getPassengerIdCard().equals("000000001")){
            ticketDto.setPassengerIdCard("");
        }
        ticketDto.setTicketId(id);
//        ticketDto.setTicketStatus(1);
        Ticket ticket= new Ticket();
        BeanUtils.copyProperties(ticketDto,ticket);
        ticketService.save(ticket);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @GetMapping(value = "/{id}")
    public ResponseEntity<Ticket> findTicketById(@PathVariable Long id) {
        Optional<Ticket> ticket = ticketService.findById(id);
        if (!ticket.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(ticket.get(), HttpStatus.OK);
    }
    @GetMapping(value = "/manyticket/{listId}")
    public ResponseEntity<List<Ticket>> findManyTicketById(@PathVariable Optional<String> listId) {
        List<Ticket> listTicket = new ArrayList<>();
        String[] arrayStr = listId.get().split(",");
        for (int i=0;i< arrayStr.length;i++){
            Optional<Ticket> ticket = ticketService.findById(Long.valueOf(arrayStr[i]));
            if (ticket.isPresent()){
                listTicket.add(ticket.get());
            }

        }
        if (listTicket.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(listTicket, HttpStatus.OK);
    }

}
