package com.backend.airline_tickets_agency_management.model.entity.flight_ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ticket_status")
public class TicketStatus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_status_id")
    private Long ticketStatusId;
    private String ticketStatusName;


    @OneToMany(mappedBy = "ticketStatus")
    @JsonBackReference
    private List<Ticket> tickets;

}
