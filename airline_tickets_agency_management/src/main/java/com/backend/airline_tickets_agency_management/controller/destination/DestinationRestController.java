package com.backend.airline_tickets_agency_management.controller.destination;

import com.backend.airline_tickets_agency_management.model.dto.destination.DestinatonDto;
import com.backend.airline_tickets_agency_management.model.dto.destination.ScenicDto;
import com.backend.airline_tickets_agency_management.model.service.destination.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("api/destination")
public class DestinationRestController {
    @Autowired
    private IDestinationService destinationService;
    @CrossOrigin
    @PutMapping(value= "/create")
    public Map<String,Object> updateUser(@Valid @RequestBody DestinatonDto destinatonDto,
                                         BindingResult bindingResult,
                                         @RequestBody ScenicDto[] listScenic) {
        return destinationService.save(destinatonDto,bindingResult,listScenic);
    }
}
