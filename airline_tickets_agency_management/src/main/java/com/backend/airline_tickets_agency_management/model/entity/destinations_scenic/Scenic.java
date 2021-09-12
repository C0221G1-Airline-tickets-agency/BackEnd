package com.backend.airline_tickets_agency_management.model.entity.destinations_scenic;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "scenic")
public class Scenic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scenicId;
    private String scenicName;
    private String scenicDescription;
    private String scenicImage;
    @ManyToOne
    @JoinColumn(name = "destination_id" )
    private Destination destination;


}
