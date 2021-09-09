package com.backend.airline_tickets_agency_management.model.repository.flight_ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ILocationRepository extends JpaRepository<Location, Long> {
    @Query(value = "select * from Location", nativeQuery = true)
    List<Location> findAll();
}
