package com.backend.airline_tickets_agency_management.controller.destination;

import com.backend.airline_tickets_agency_management.model.dto.destination.DestinatonDto;
import com.backend.airline_tickets_agency_management.model.dto.destination.ScenicDto;
import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Destination;
import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Scenic;
import com.backend.airline_tickets_agency_management.model.service.destination.IDestinationService;
import com.backend.airline_tickets_agency_management.model.service.destination.IScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/destination")
public class DestinationRestController {
    @Autowired
    private IDestinationService destinationService;
    @Autowired
    private IScenicService scenicService;

    @CrossOrigin
    @PostMapping(value = "/create")
    public Map<String, Object> saveDestination(@Valid @RequestBody DestinatonDto destinatonDto,
                                               BindingResult bindingResult) {
        return destinationService.save(destinatonDto, bindingResult);
    }

    @CrossOrigin
    @GetMapping(value = "/{id}")
    public ResponseEntity<Destination> findDestination(@PathVariable Long id) {
        Optional<Destination> destinationOptional = destinationService.findById(id);
        if (!destinationOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(destinationOptional.get(), HttpStatus.OK);
    }

    @CrossOrigin
    @PutMapping(value = "/edit")
    public Map<String, Object> updateDestination(@Valid @RequestBody DestinatonDto destinatonDto,
                                                 BindingResult bindingResult) {
        return destinationService.update(destinatonDto, bindingResult);
    }

    @CrossOrigin
    @GetMapping(value = "/scenics")
    public ResponseEntity<Iterable<Scenic>> findScenicByDestination(@RequestParam Long idDestination) {
        Iterable<Scenic> scenics = scenicService.getScenicByDestination(idDestination);
        return new ResponseEntity<>(scenics, HttpStatus.OK);
    }

    @CrossOrigin
    @DeleteMapping(value = "/scenic/{id}")
    public ResponseEntity<Void> DelScenic(@PathVariable Long id) {
        scenicService.delScenic(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/scenic/create")
    public Map<String, Object> saveScenic(@Valid @RequestBody ScenicDto scenicDto,
                                          BindingResult bindingResult) {
        return scenicService.save(scenicDto, bindingResult);
    }

    @CrossOrigin
    @PutMapping(value = "/scenic/edit")
    public Map<String, Object> updateScenic(@Valid @RequestBody ScenicDto scenicDto,
                                          BindingResult bindingResult) {
        return scenicService.update(scenicDto, bindingResult);
    }

    @CrossOrigin
    @GetMapping(value = "/scenic/{id}")
    public ResponseEntity<Scenic> findScenic(@PathVariable Long id) {
        Optional<Scenic> scenicOptional = scenicService.findById(id);
        if (!scenicOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(scenicOptional.get(), HttpStatus.OK);
    }
}
