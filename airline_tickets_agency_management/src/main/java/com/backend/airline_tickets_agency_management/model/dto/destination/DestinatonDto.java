package com.backend.airline_tickets_agency_management.model.dto.destination;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class DestinatonDto {
    private Long destinationId;
    @NotEmpty
    private String destinationName;
    @NotEmpty
    private String destinationDescription;
    @NotEmpty
    private String destinationImage;
    private List<ScenicDto> listScenic;


    public DestinatonDto() {
    }

    public DestinatonDto(@NotEmpty String destinationName, @NotEmpty String destinationDescription, @NotEmpty String destinationImage, List<ScenicDto> listScenic) {
        this.destinationName = destinationName;
        this.destinationDescription = destinationDescription;
        this.destinationImage = destinationImage;
        this.listScenic = listScenic;
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

    public List<ScenicDto> getListScenic() {
        return listScenic;
    }

    public void setListScenic(List<ScenicDto> listScenic) {
        this.listScenic = listScenic;
    }
}
