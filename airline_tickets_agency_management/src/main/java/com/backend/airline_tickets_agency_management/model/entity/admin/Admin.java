package com.backend.airline_tickets_agency_management.model.entity.admin;
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
@Table(name = "admin")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;
    private String adminName;
    private String adminBirthday;
    private String adminAddress;
    private String adminEmail;
    private String adminGender;
    private String adminPhone;
    private String adminImg;
}
