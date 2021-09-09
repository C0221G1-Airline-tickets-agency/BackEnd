package com.backend.airline_tickets_agency_management.model.repository.destiantion_scenic.scenic;

import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Scenic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ScenicRepository extends JpaRepository<Scenic,Long> {
    @Query(value="SELECT * FROM airline_tickets_agency_management.scenic where flag=1 and destination_id =?1" ,nativeQuery=true)
    List<Scenic>findScenicByDestinationId(Long id);
}
