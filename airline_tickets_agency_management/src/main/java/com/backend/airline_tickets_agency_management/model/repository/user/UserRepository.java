package com.backend.airline_tickets_agency_management.model.repository.user;
import com.backend.airline_tickets_agency_management.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
    Boolean existsByUserName(String username);
}
