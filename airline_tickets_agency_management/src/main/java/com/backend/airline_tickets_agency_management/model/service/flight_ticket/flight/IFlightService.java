package com.backend.airline_tickets_agency_management.model.service.flight_ticket.flight;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Flight;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IFlightService {
    Page<Flight> findAllFlightPage(Pageable pageable);
    void deleteId(Long id);
    Page<Flight> findBycode(String code,Pageable pageable);
    Page<Flight> findByPrice(String code,Pageable pageable);
    Flight findById(Long id);

    Flight findFlightById(Long id);
    Flight saveFlight(Flight flight);
}
