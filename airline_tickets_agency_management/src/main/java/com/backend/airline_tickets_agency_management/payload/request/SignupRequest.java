package com.backend.airline_tickets_agency_management.payload.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

public class SignupRequest {
    @NotBlank
    @Email
    private String username;

//    @Size(max = 50)
    private String userCode;
    private Boolean isEnabled;

    private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 40)
    private String password;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public Boolean getEnabled() {
        return isEnabled;
    }

    public void setEnabled(Boolean enabled) {
        isEnabled = enabled;
    }

    public Set<String> getRole() {
        return role;
    }

    public void setRole(Set<String> role) {
        this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "SignupRequest{" +
                "username='" + username + '\'' +
                ", userCode='" + userCode + '\'' +
                ", isEnabled=" + isEnabled +
                ", role=" + role +
                ", password='" + password + '\'' +
                '}';
    }
}
