package com.backend.airline_tickets_agency_management.model.service.destination;

import com.backend.airline_tickets_agency_management.model.dto.destination.DestinatonDto;
import com.backend.airline_tickets_agency_management.model.dto.destination.ScenicDto;
import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Destination;
import org.springframework.validation.BindingResult;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface IDestinationService {
    Optional<Destination> findById(Long id);

    Map<String,Object> save(DestinatonDto destinatonDto, BindingResult bindingResult, ScenicDto[] listScenic);
}
