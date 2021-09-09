package com.backend.airline_tickets_agency_management.controller;
import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Destination;
import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Scenic;
import com.backend.airline_tickets_agency_management.model.service.IDestinationService;
import com.backend.airline_tickets_agency_management.model.service.IScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin("http://localhost:4200/")
@RequestMapping("api/destination")
public class DestinationController {
    @Autowired
    private IDestinationService destinationService;
    @Autowired
    private IScenicService scenicService;
    @GetMapping("/list-destination")
    public ResponseEntity<Page<Destination>> findAllDestination(@RequestParam Optional<Integer> page, @RequestParam Optional<String> sortBy){
        Pageable pageable= PageRequest.of(page.orElse(0),6, Sort.Direction.ASC,sortBy.orElse("destination_id"));
        Page<Destination> destinationPage = destinationService.findAllDestination(pageable);
        if (destinationPage.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(destinationPage, HttpStatus.OK);
    }
    @DeleteMapping("/delete-destination")
    public ResponseEntity<Destination> deleteDestination(@RequestParam Long id){
        Destination destination=destinationService.findByIdDestination(id).orElse(null);
        if (destination==null){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }
        if (destination.getFlag()==0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        destination.setFlag(0);
        destinationService.saveDestination(destination);
        return new ResponseEntity<>(destination,HttpStatus.OK);
    }
    @GetMapping("/list-scenic")
    public ResponseEntity<List<Scenic>> getScenic(@RequestParam Long id){
        List<Scenic> scenicList=scenicService.findScenicById(id);
        if (scenicList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(scenicList,HttpStatus.OK);
    }
    @GetMapping("/find-destination")
    public ResponseEntity<Destination>findByIdDes(@RequestParam Long id){
        Destination destination=destinationService.findByIdDestination(id).orElse(null);
        if (destination == null){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(destination,HttpStatus.OK);
    }

}
