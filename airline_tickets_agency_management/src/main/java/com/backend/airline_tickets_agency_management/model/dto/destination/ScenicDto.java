package com.backend.airline_tickets_agency_management.model.dto.destination;

public class ScenicDto {
    private Long ScenicId;
    private String ScenicName;
    private String ScenicDescription;
    private String ScenicImage;

    public ScenicDto() {
    }

    public ScenicDto(String scenicName, String scenicDescription, String scenicImage) {
        ScenicName = scenicName;
        ScenicDescription = scenicDescription;
        ScenicImage = scenicImage;
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
}
