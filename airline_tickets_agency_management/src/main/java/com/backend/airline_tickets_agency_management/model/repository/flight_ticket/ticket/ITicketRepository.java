package com.backend.airline_tickets_agency_management.model.repository.flight_ticket.ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;


public interface ITicketRepository extends JpaRepository<Ticket, Long> {
    @Query(value = "select * from ticket t " +
            "join flight f on t.flight_id = f.flight_id " +
            "join location l1 on f.destination = l1.location_id " +
            "join location l2 on f.point_of_departure = l2.location_id " +
            "where t.passenger_name like %?1% " +
            "and t.chair_name like %?2% " +
            "and (l1.city_name like %?3% or l2.city_name like %?3%) " +
            "and f.flight_date like %?4% " +
            "and t.flag = 1", nativeQuery = true)
    Page<Ticket> findAllByFilter(String passengerName, String chairName, String cityName, String flightDate, Pageable pageable);

    @Modifying
    @Transactional
    @Query(value = "update ticket t set t.flag = 0 where t.ticket_id = ?1", nativeQuery = true)
    void deleteTicket(Long id);
}
