package com.backend.airline_tickets_agency_management.model.service;
import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Destination;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface IDestinationService {
    Page<Destination>findAllDestination(Pageable pageable);
    Optional<Destination> findByIdDestination(Long id);
    void deleteDestination(Long id);
    void saveDestination(Destination destination);

}
