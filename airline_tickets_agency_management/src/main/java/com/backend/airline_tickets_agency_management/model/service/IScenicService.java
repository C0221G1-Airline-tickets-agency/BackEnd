package com.backend.airline_tickets_agency_management.model.service;

import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Scenic;

import java.util.List;

public interface IScenicService {
    List<Scenic> findScenicById(Long id);
}
