package com.backend.airline_tickets_agency_management.model.service.destination;

import com.backend.airline_tickets_agency_management.model.dto.destination.DestinatonDto;
import com.backend.airline_tickets_agency_management.model.dto.destination.ScenicDto;
import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Destination;
import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Scenic;
import com.backend.airline_tickets_agency_management.model.repository.destination.IDestinationRepository;
import com.backend.airline_tickets_agency_management.model.repository.destination.IScenicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.util.*;

@Service
public class DestinationServiceImpl implements IDestinationService {
    @Autowired
    private IDestinationRepository destinationRepository;
    @Autowired
    private IScenicRepository scenicRepository;

    @Override
    public Optional<Destination> findById(Long id) {
        return destinationRepository.findById(id);
    }

    @Override
    public Map<String, Object> save(DestinatonDto destinatonDto,
                                    BindingResult bindingResult,
                                    ScenicDto[] listScenic) {
        Map<String, Object> result = new HashMap<>();
        List<String> errors = new ArrayList<>();
        try{
            if (bindingResult.hasErrors()) {
                bindingResult.getAllErrors().forEach(ob -> {
                    errors.add(ob.getDefaultMessage());
                });
                result.put("status", false);
                result.put("msg", "SAVE FAILED");
                result.put("errors", errors);
                return result;
            }
            if (listScenic.length == 0){
                result.put("status", false);
                result.put("msg", "SAVE FAILED");
                errors.add("Chưa có địa danh");
                result.put("errors", errors);
                return result;
            }
        } catch (Exception e){
            result.put("status", false);
            result.put("msg", "UPDATE FAILED");
        }

        Destination destination = new Destination();
        destination.setDestinationName(destinatonDto.getDestinationName());
        destination.setDestinationDescription(destinatonDto.getDestinationDescription());
        destination.setDestinationImage(destinatonDto.getDestinationImage());
        destination.setFlag(1);
        destinationRepository.save(destination);

        Destination destination1 = destinationRepository.findDestinationByDestinationName(destinatonDto.getDestinationName());
        for (int i = 0; i < listScenic.length ; i++) {
            Scenic scenic = new Scenic();
            scenic.setScenicName(listScenic[i].getScenicName());
            scenic.setScenicDescription(listScenic[i].getScenicDescription());
            scenic.setScenicImage(listScenic[i].getScenicImage());
            scenic.setFlag(1);
            scenic.setDestination(destination1);
            scenicRepository.save(scenic);
        }

        result.put("status", true);
        result.put("msg", "Tạo điểm đến thành công!!!");
        return result;
    }
}
