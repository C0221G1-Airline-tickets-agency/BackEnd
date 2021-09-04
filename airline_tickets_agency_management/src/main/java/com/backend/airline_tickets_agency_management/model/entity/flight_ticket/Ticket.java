package com.backend.airline_tickets_agency_management.model.entity.flight_ticket;

import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;

import javax.persistence.*;

@Entity
@Table(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticket_id")
    private Long ticketId;
    private String ticketCode;
    private Boolean plusBaby;
    private Double plusBaggage;
    private String ticketType;
    private Double ticketTypePrice;
    private Double ticketPrice;
    private Double tax;
    private String bookingDate;
    private Integer checkInBaggage;
    private Integer carryOnBaggage;
    private String passengerType;
    private String passengerTypePrice;
    private String passengerName;
    private String passengerGender;
    private String passengerPhone;
    private String passengerIdCard;
    private String passengerEmail;
    private Boolean flag = true;

    @ManyToOne
    @JoinColumn(name = "flight_id",referencedColumnName = "flight_id")
    private Flight flight;


    @ManyToOne
    @JoinColumn(name = "ticket_status_id",referencedColumnName ="ticket_status_id" )
    private TicketStatus ticketStatus;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public Ticket() {
    }

    public Ticket(Long ticketId, String ticketCode, Boolean plusBaby, Double plusBaggage, String ticketType, Double ticketTypePrice, Double ticketPrice, Double tax, String bookingDate, Integer checkInBaggage, Integer carryOnBaggage, String passengerType, String passengerTypePrice, String passengerName, String passengerGender, String passengerPhone, String passengerIdCard, String passengerEmail, Boolean flag, Flight flight, TicketStatus ticketStatus, Customer customer) {
        this.ticketId = ticketId;
        this.ticketCode = ticketCode;
        this.plusBaby = plusBaby;
        this.plusBaggage = plusBaggage;
        this.ticketType = ticketType;
        this.ticketTypePrice = ticketTypePrice;
        this.ticketPrice = ticketPrice;
        this.tax = tax;
        this.bookingDate = bookingDate;
        this.checkInBaggage = checkInBaggage;
        this.carryOnBaggage = carryOnBaggage;
        this.passengerType = passengerType;
        this.passengerTypePrice = passengerTypePrice;
        this.passengerName = passengerName;
        this.passengerGender = passengerGender;
        this.passengerPhone = passengerPhone;
        this.passengerIdCard = passengerIdCard;
        this.passengerEmail = passengerEmail;
        this.flag = flag;
        this.flight = flight;
        this.ticketStatus = ticketStatus;
        this.customer = customer;
    }

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Boolean getPlusBaby() {
        return plusBaby;
    }

    public void setPlusBaby(Boolean plusBaby) {
        this.plusBaby = plusBaby;
    }

    public Double getPlusBaggage() {
        return plusBaggage;
    }

    public void setPlusBaggage(Double plusBaggage) {
        this.plusBaggage = plusBaggage;
    }

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public Double getTicketTypePrice() {
        return ticketTypePrice;
    }

    public void setTicketTypePrice(Double ticketTypePrice) {
        this.ticketTypePrice = ticketTypePrice;
    }

    public Double getTicketPrice() {
        return ticketPrice;
    }

    public void setTicketPrice(Double ticketPrice) {
        this.ticketPrice = ticketPrice;
    }

    public Double getTax() {
        return tax;
    }

    public void setTax(Double tax) {
        this.tax = tax;
    }

    public String getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(String bookingDate) {
        this.bookingDate = bookingDate;
    }

    public Integer getCheckInBaggage() {
        return checkInBaggage;
    }

    public void setCheckInBaggage(Integer checkInBaggage) {
        this.checkInBaggage = checkInBaggage;
    }

    public Integer getCarryOnBaggage() {
        return carryOnBaggage;
    }

    public void setCarryOnBaggage(Integer carryOnBaggage) {
        this.carryOnBaggage = carryOnBaggage;
    }

    public String getPassengerType() {
        return passengerType;
    }

    public void setPassengerType(String passengerType) {
        this.passengerType = passengerType;
    }

    public String getPassengerTypePrice() {
        return passengerTypePrice;
    }

    public void setPassengerTypePrice(String passengerTypePrice) {
        this.passengerTypePrice = passengerTypePrice;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(String passengerGender) {
        this.passengerGender = passengerGender;
    }

    public String getPassengerPhone() {
        return passengerPhone;
    }

    public void setPassengerPhone(String passengerPhone) {
        this.passengerPhone = passengerPhone;
    }

    public String getPassengerIdCard() {
        return passengerIdCard;
    }

    public void setPassengerIdCard(String passengerIdCard) {
        this.passengerIdCard = passengerIdCard;
    }

    public String getPassengerEmail() {
        return passengerEmail;
    }

    public void setPassengerEmail(String passengerEmail) {
        this.passengerEmail = passengerEmail;
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public TicketStatus getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(TicketStatus ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
