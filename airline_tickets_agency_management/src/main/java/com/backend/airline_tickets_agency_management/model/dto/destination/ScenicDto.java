package com.backend.airline_tickets_agency_management.model.dto.destination;

import com.backend.airline_tickets_agency_management.model.entity.destinations_scenic.Destination;

public class ScenicDto {
    private Long ScenicId;
    private String ScenicName;
    private String ScenicDescription;
    private String ScenicImage;
    private Destination destination;

    public ScenicDto() {
    }

    public ScenicDto(String scenicName, String scenicDescription, String scenicImage, Destination destination) {
        ScenicName = scenicName;
        ScenicDescription = scenicDescription;
        ScenicImage = scenicImage;
        this.destination = destination;
    }

    public Long getScenicId() {
        return ScenicId;
    }

    public void setScenicId(Long scenicId) {
        ScenicId = scenicId;
    }

    public String getScenicName() {
        return ScenicName;
    }

    public void setScenicName(String scenicName) {
        ScenicName = scenicName;
    }

    public String getScenicDescription() {
        return ScenicDescription;
    }

    public void setScenicDescription(String scenicDescription) {
        ScenicDescription = scenicDescription;
    }

    public String getScenicImage() {
        return ScenicImage;
    }

    public void setScenicImage(String scenicImage) {
        ScenicImage = scenicImage;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }
}
