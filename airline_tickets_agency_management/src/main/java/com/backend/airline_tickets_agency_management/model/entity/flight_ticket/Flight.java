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
@Table(name = "flight")
public class Flight {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "flight_id")
    private Long flightId;
    private String flightCode;
    @Column(columnDefinition = "date")
    private String flightDate;
    private String departureTime;
    private String endTime;
    private Boolean flag = true;


    @ManyToOne
    @JoinColumn(name = "airline_id",referencedColumnName = "airline_id")
    private Airline airline;

    @OneToMany(mappedBy = "flight")
    @JsonBackReference
    private List<Ticket> tickets;

    @ManyToOne
    @JoinColumn(name = "point_of_departure",referencedColumnName = "location_id")
    private Location locationTo;

    @ManyToOne
    @JoinColumn(name = "destination",referencedColumnName = "location_id")
    private Location locationFrom;

}
