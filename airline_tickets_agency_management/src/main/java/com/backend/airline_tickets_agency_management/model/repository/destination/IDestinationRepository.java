package com.backend.airline_tickets_agency_management.model.repository.destination;

import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IDestinationRepository extends JpaRepository<Destination,Long> {
    Destination findByDestinationName(String destinationName);
}
