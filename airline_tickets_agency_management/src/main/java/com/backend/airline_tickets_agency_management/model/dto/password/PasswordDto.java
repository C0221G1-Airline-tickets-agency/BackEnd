package com.backend.airline_tickets_agency_management.model.dto.password;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordDto {
    private String oldPassword;
    private String newPassword;
    private String confirmPassword;
}
