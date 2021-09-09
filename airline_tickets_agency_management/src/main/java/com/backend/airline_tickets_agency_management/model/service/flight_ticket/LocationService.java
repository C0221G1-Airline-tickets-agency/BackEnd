package com.backend.airline_tickets_agency_management.model.service.flight_ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Location;
import com.backend.airline_tickets_agency_management.model.repository.flight_ticket.ILocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationService implements ILocationService{
    @Autowired
    private ILocationRepository iLocationRepository;

    @Override
    public List<Location> findAll() {
        return iLocationRepository.findAll();
    }
}
