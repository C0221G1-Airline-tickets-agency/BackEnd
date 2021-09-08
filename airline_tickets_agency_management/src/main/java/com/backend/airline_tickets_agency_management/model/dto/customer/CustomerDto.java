package com.backend.airline_tickets_agency_management.model.dto.customer;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Ticket;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Column;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

public class CustomerDto {
    private Long customerId;
    private String customerCode;
    @NotBlank(message = "Tên không được để trống")
    @Size(min= 6,message = "Tên ít nhất 6 ký tự")
    private String customerName;
    @NotBlank(message = "Email không được để trống")
    private String customerEmail;
    @NotBlank(message = "Số điện thoại không được để trống")
    private String customerPhone;
    private String customerGender;
    @NotBlank(message = "Không được để trống")
    private String customerBirthday;
    private String customerNationality;
    private String customerImage;
    private String customerAddress;
    @NotBlank(message = "Không được để trống")
    private String customerPassport;
    private Boolean flag = true;
    private List<Ticket> tickets;

    public CustomerDto() {
    }

    public CustomerDto(Long customerId, String customerCode, String customerName,
                       String customerEmail, String customerPhone, String customerGender,
                       String customerBirthday, String customerNationality,
                       String customerImage, String customerAddress, String customerPassport, boolean flag, List<Ticket> tickets) {
        this.customerId = customerId;
        this.customerCode = customerCode;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhone = customerPhone;
        this.customerGender = customerGender;
        this.customerBirthday = customerBirthday;
        this.customerNationality = customerNationality;
        this.customerImage = customerImage;
        this.customerAddress = customerAddress;
        this.customerPassport = customerPassport;
        this.flag = flag;
        this.tickets = tickets;
    }

    public String getCustomerPassport() {
        return customerPassport;
    }

    public void setCustomerPassport(String customerPassport) {
        this.customerPassport = customerPassport;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(String customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerBirthday() {
        return customerBirthday;
    }

    public void setCustomerBirthday(String customerBirthday) {
        this.customerBirthday = customerBirthday;
    }

    public String getCustomerNationality() {
        return customerNationality;
    }

    public void setCustomerNationality(String customerNationality) {
        this.customerNationality = customerNationality;
    }

    public String getCustomerImage() {
        return customerImage;
    }

    public void setCustomerImage(String customerImage) {
        this.customerImage = customerImage;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }
}
