package com.backend.airline_tickets_agency_management.model.entity.destinations_scenic;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "destinations")
public class Destination {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long destinationId;
    private String destinationName;
    private String destinationDescription;
    private String destinationImage;
    @OneToMany(mappedBy = "destination")
    @JsonBackReference
    private List<Scenic> scenics;

}
