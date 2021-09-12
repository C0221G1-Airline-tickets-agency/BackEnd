//package com.backend.airline_tickets_agency_management.model.entity.destinations_scenic;
//import javax.persistence.*;
//
//@Entity
//@Table(name = "scenic")
//public class Scenic {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long ScenicId;
//    private String ScenicName;
//    private String ScenicDescription;
//    private String ScenicImage;
//    @ManyToOne
//    @JoinColumn(name = "destination_id" )
//    private Destination destination;
//
//    public Scenic() {
//    }
//
//    public Long getScenicId() {
//        return ScenicId;
//    }
//
//    public void setScenicId(Long scenicId) {
//        ScenicId = scenicId;
//    }
//
//    public String getScenicName() {
//        return ScenicName;
//    }
//
//    public void setScenicName(String scenicName) {
//        ScenicName = scenicName;
//    }
//
//    public String getScenicDescription() {
//        return ScenicDescription;
//    }
//
//    public void setScenicDescription(String scenicDescription) {
//        ScenicDescription = scenicDescription;
//    }
//
//    public String getScenicImage() {
//        return ScenicImage;
//    }
//
//    public void setScenicImage(String scenicImage) {
//        ScenicImage = scenicImage;
//    }
//
//    public Destination getDestination() {
//        return destination;
//    }
//
//    public void setDestination(Destination destination) {
//        this.destination = destination;
//    }
//}
