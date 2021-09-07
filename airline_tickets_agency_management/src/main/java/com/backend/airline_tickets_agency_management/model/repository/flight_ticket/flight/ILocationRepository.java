package com.backend.airline_tickets_agency_management.model.repository.flight_ticket.flight;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Location;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ILocationRepository extends PagingAndSortingRepository<Location,Long> {
}
