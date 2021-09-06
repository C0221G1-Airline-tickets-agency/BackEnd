package com.backend.airline_tickets_agency_management.model.service.user;

import com.backend.airline_tickets_agency_management.model.entity.user.User;


public interface IUserService {
    User findById(Long id);
    void save(User user);
}
