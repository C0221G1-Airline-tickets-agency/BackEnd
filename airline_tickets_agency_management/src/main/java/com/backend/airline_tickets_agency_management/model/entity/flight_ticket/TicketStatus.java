package com.backend.airline_tickets_agency_management.model.entity.flight_ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.persistence.*;
import java.util.List;
@Entity
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

    public TicketStatus() {
    }

    public TicketStatus(Long ticketStatusId, String ticketStatusName, List<Ticket> tickets) {
        this.ticketStatusId = ticketStatusId;
        this.ticketStatusName = ticketStatusName;
        this.tickets = tickets;
    }

    public Long getTicketStatusId() {
        return ticketStatusId;
    }

    public void setTicketStatusId(Long ticketStatusId) {
        this.ticketStatusId = ticketStatusId;
    }

    public String getTicketStatusName() {
        return ticketStatusName;
    }

    public void setTicketStatusName(String ticketStatusName) {
        this.ticketStatusName = ticketStatusName;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
