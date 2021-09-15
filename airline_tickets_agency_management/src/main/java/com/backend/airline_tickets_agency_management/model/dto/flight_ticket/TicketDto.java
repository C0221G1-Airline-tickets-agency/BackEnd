package com.backend.airline_tickets_agency_management.model.dto.flight_ticket;

import com.backend.airline_tickets_agency_management.model.entity.customer.Customer;
import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Flight;
import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.TicketStatus;

import com.backend.airline_tickets_agency_management.model.entity.user.User;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Getter
@Setter
public class TicketDto {
    private Long ticketId;
    private String ticketCode;
    private Boolean plusBaby;
    @NumberFormat(pattern = "^[1-9]\\d*$")
    private Double plusBaggage;
    private String ticketType;
    private Double ticketTypePrice;
    private Double ticketPrice;
    private Double tax;
    private String chairName;
    private String bookingDate;
    private Integer checkInBaggage;
    private Integer carryOnBaggage;
    private String passengerType;
    private Double passengerTypePrice;
    @NotBlank
    @Size(max = 50, min = 10)
    @Pattern(regexp = "[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴa-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ ]*")

    private String passengerName;
    @NotBlank
    private String passengerGender;
    @Pattern(regexp = "^\\(\\+84\\)+90[0-9]{7}|\\(\\+84\\)+91[0-9]{7}$")
    private String passengerPhone;
    @NotBlank
    @Pattern(regexp = "^[0-9]{9,10}$")
    private String passengerIdCard;
    @Email
    @Pattern(regexp = "[A-Za-z0-9._%-]+@[A-Za-z0-9._%-]+\\.[a-z]{2,3}")
    private String passengerEmail;
    private Flight flight;
    private TicketStatus ticketStatus;

    private User user;

}
