package com.backend.airline_tickets_agency_management.model.service.destination_Scenic;

import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Destination;
import com.backend.airline_tickets_agency_management.model.repository.destiantion_scenic.destiantion.DestinationRepository;
import com.backend.airline_tickets_agency_management.model.service.IDestinationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DestinationService implements IDestinationService {
    @Autowired
    private DestinationRepository destinationRepository;


    @Override
    public Page<Destination> findAllDestination(Pageable pageable) {
        return destinationRepository.findAllDestination(pageable);
    }

    @Override
    public Optional<Destination> findByIdDestination(Long id) {
        return destinationRepository.findById(id);

    }



    @Override
    public void deleteDestination(Long id) {
        Optional<Destination> destination= destinationRepository.findById(id);
    }

    @Override
    public void saveDestination(Destination destination) {
        destinationRepository.save(destination);
    }
}
