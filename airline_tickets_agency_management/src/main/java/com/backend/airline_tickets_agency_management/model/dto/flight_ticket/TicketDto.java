package com.backend.airline_tickets_agency_management.model.dto.flight_ticket;

import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.Flight;
import com.backend.airline_tickets_agency_management.model.entity.flight_ticket.TicketStatus;
import com.backend.airline_tickets_agency_management.model.entity.user.User;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Getter
@Setter
public class TicketDto {
    private Long ticketId;
    private String ticketCode;
    private Boolean plusBaby;
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
    @Pattern(regexp = "^[A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]+([ ][A-ZẮẰẲẴẶĂẤẦẨẪẬÂÁÀÃẢẠĐẾỀỂỄỆÊÉÈẺẼẸÍÌỈĨỊỐỒỔỖỘÔỚỜỞỠỢƠÓÒÕỎỌỨỪỬỮỰƯÚÙỦŨỤÝỲỶỸỴ][a-zàáâãèéêìíòóôõùúăđĩũơưăạảấầẩẫậắằẳẵặẹẻẽềềểễệỉịọỏốồổỗộớờởỡợụủứừửữựỳỵỷỹ]+)+$")
    private String passengerName;
    private String passengerGender;
    private String passengerPhone;
    private String passengerIdCard;
    @NotBlank
    @Email
    private String passengerEmail;
    private Flight flight;
    private TicketStatus ticketStatus;
    private User user;
}