package com.backend.airline_tickets_agency_management.model.entity.employee;

import com.backend.airline_tickets_agency_management.model.entity.news.News;
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
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    private String employeeCode;
    private String employeeName;
    @Column(columnDefinition = "date")
    private String employeeBirthday;
    private String employeeGender;
    private String employeePhoneNumber;
    private String employeeAddress;
    private String employeeImage;
    private boolean flag = true;
    @OneToMany(mappedBy = "employee")
    @JsonBackReference
    private List<News> news;

}
