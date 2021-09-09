package com.backend.airline_tickets_agency_management.model.service.destination_Scenic;


import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Scenic;
import com.backend.airline_tickets_agency_management.model.repository.destiantion_scenic.scenic.ScenicRepository;
import com.backend.airline_tickets_agency_management.model.service.IScenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ScenicService implements IScenicService {
    @Autowired
    private ScenicRepository scenicRepository;
    @Override
    public List<Scenic> findScenicById(Long id) {
        return scenicRepository.findScenicByDestinationId(id);
    }
}
