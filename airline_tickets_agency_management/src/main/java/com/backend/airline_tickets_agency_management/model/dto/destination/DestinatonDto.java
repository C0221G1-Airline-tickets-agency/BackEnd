package com.backend.airline_tickets_agency_management.model.dto.destination;

import javax.validation.constraints.NotEmpty;

public class DestinatonDto {
    private Long destinationId;
    @NotEmpty
    private String destinationName;
    @NotEmpty
    private String destinationDescription;
    @NotEmpty
    private String destinationImage;


    public DestinatonDto() {
    }

    public DestinatonDto(String destinationName, String destinationDescription, String destinationImage) {
        this.destinationName = destinationName;
        this.destinationDescription = destinationDescription;
        this.destinationImage = destinationImage;
    }

    public Long getDestinationId() {
        return destinationId;
    }

    public void setDestinationId(Long destinationId) {
        this.destinationId = destinationId;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public String getDestinationDescription() {
        return destinationDescription;
    }

    public void setDestinationDescription(String destinationDescription) {
        this.destinationDescription = destinationDescription;
    }

    public String getDestinationImage() {
        return destinationImage;
    }

    public void setDestinationImage(String destinationImage) {
        this.destinationImage = destinationImage;
    }
}
