package com.backend.airline_tickets_agency_management.model.entity.destinations_scenic;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "scenic")
public class Scenic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long scenicId;
    private String scenicName;
    private String scenicDescription;
    private String scenicImage;
    private Integer flag;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "destination_id" )
    private Destination destination;
    public Long getScenicId() {
        return scenicId;
    }

    public void setScenicId(Long scenicId) {
        this.scenicId = scenicId;
    }

    public String getScenicName() {
        return scenicName;
    }

    public void setScenicName(String scenicName) {
        this.scenicName = scenicName;
    }

    public String getScenicDescription() {
        return scenicDescription;
    }

    public void setScenicDescription(String scenicDescription) {
        this.scenicDescription = scenicDescription;
    }

    public String getScenicImage() {
        return scenicImage;
    }

    public void setScenicImage(String scenicImage) {
        this.scenicImage = scenicImage;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
