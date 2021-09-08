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
    public Map<String, Object> save(DestinatonDto destinatonDto, BindingResult bindingResult) {
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
            if (destinatonDto.getListScenic().size() == 0){
                result.put("status", false);
                result.put("msg", "SAVE FAILED");
                errors.add("Chưa có địa danh");
                result.put("errors", errors);
                return result;
            }
        } catch (Exception e){
            result.put("status", false);
            result.put("msg", "SAVE FAILED");
        }

        Destination destination = new Destination();
        destination.setDestinationName(destinatonDto.getDestinationName());
        destination.setDestinationDescription(destinatonDto.getDestinationDescription());
        destination.setDestinationImage(destinatonDto.getDestinationImage());
        destination.setFlag(1);
        destinationRepository.save(destination);

        for (ScenicDto scenicDto:destinatonDto.getListScenic()) {
            Scenic scenic = new Scenic();
            scenic.setScenicName(scenicDto.getScenicName());
            scenic.setScenicDescription(scenicDto.getScenicDescription());
            scenic.setScenicImage(scenicDto.getScenicImage());
            scenic.setDestination(destination);
            scenic.setFlag(1);
            scenicRepository.save(scenic);
        }

        result.put("status", true);
        result.put("msg", "Tạo điểm đến thành công!!!");
        return result;
    }

    @Override
    public Map<String, Object> update(DestinatonDto destinatonDto, BindingResult bindingResult) {
        Destination destination = destinationRepository.findById(destinatonDto.getDestinationId()).orElse(null);
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
            if (destination == null){
                result.put("status", false);
                result.put("msg", "SAVE FAILED");
                errors.add("Điểm đến không tồn tại");
                result.put("errors", errors);
                return result;
            }
            if (destinatonDto.getListScenic().size() == 0){
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
        destination.setDestinationId(destinatonDto.getDestinationId());
        destination.setDestinationName(destinatonDto.getDestinationName());
        destination.setDestinationDescription(destinatonDto.getDestinationDescription());
        destination.setDestinationImage(destinatonDto.getDestinationImage());
        destination.setFlag(1);
        destinationRepository.save(destination);

        result.put("status", true);
        result.put("msg", "Cập nhật điểm đến thành công!!!");
        return result;
    }
}
