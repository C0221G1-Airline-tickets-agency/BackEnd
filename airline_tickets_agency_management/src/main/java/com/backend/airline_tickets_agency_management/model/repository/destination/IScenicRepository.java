package com.backend.airline_tickets_agency_management.model.repository.destination;

import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Scenic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IScenicRepository extends JpaRepository<Scenic,Long> {
}
