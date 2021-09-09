package com.backend.airline_tickets_agency_management.model.repository.flight_ticket;

import com.backend.airline_tickets_agency_management.model.dto.flight_ticket.SearchFlightDto;
import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ISearchFlightRepository extends JpaRepository<Ticket, Integer> {
    @Query(value = "select f.flight_id as flightId, f.flight_code as flightCode, f.departure_time as departureTime, f.end_time as endTime, f.point_of_departure as pointOfDeparture, f.destination as destination, f.flight_date as flightDate, al.airline_name as airlineName,\n" +
            "t.ticket_type as ticketType, t.passenger_type as passengerType, (t.ticket_price*(1+t.passenger_type_price)*(1-t.passenger_type_price)*(1-t.tax)) as price\n" +
            "from flight f\n" +
            "join airline al on f.airline_id = al.airline_id\n" +
            "join ticket t on t.flight_id = f.flight_id\n" +
            "where f.flag = 1 and t.flag = 1 and (t.ticket_status_id is null or t.ticket_status_id = 3) and f.point_of_departure = ?1 and f.destination = ?2 and f.flight_date = ?3 and (t.passenger_type = ?4 or t.passenger_type = ?5) ", nativeQuery = true)
    List<SearchFlightDto> searchFlight(String pointOfDeparture, String destination, String flightDate, String passengerType1, String passengerType2);


}
