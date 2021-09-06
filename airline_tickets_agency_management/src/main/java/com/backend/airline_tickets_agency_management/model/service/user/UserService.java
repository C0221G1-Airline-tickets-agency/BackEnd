package com.backend.airline_tickets_agency_management.model.service.user;

import com.backend.airline_tickets_agency_management.model.entity.user.User;
import com.backend.airline_tickets_agency_management.model.repository.user.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public User findById(Long id) {
        return this.iUserRepository.findById(id).orElse(null);
    }

    @Override
    public void save(User user) {
        this.iUserRepository.save(user);
    }
}
