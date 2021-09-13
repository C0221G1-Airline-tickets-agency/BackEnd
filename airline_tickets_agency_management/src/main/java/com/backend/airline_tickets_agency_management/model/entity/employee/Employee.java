package com.backend.airline_tickets_agency_management.model.entity.employee;

import com.backend.airline_tickets_agency_management.model.entity.news.News;
import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;


import javax.persistence.*;
import java.util.List;

@Entity
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

    public Employee() {
    }

    public Employee(String employeeCode, String employeeName, String employeeBirthday, String employeeGender, String employeePhoneNumber, String employeeAddress, String employeeImage) {
        this.employeeCode = employeeCode;
        this.employeeName = employeeName;
        this.employeeBirthday = employeeBirthday;
        this.employeeGender = employeeGender;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeAddress = employeeAddress;
        this.employeeImage = employeeImage;
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeGender() {
        return employeeGender;
    }

    public void setEmployeeGender(String employeeGender) {
        this.employeeGender = employeeGender;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public String getEmployeeImage() {
        return employeeImage;
    }

    public void setEmployeeImage(String employeeImage) {
        this.employeeImage = employeeImage;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
