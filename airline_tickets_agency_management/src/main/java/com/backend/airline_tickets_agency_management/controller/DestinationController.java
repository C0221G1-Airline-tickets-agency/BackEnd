package com.backend.airline_tickets_agency_management.controller;

import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Destination;
import com.backend.airline_tickets_agency_management.model.service.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/destination")
public class DestinationController {
    @Autowired
    private IDestinationService destinationService;
    @GetMapping("/list-destination")
    public ResponseEntity<Page<Destination>> findAllDestination(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy){
        Pageable pageable= PageRequest.of(page.orElse(0),6, Sort.Direction.ASC,sortBy.orElse("destination_id"));
        Page<Destination> destinationPage = destinationService.findAllDestination(pageable);
        if (destinationPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(destinationPage, HttpStatus.OK);
    }
}
