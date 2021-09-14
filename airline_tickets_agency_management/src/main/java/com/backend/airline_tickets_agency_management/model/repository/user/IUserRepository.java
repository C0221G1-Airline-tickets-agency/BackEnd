package com.backend.airline_tickets_agency_management.model.repository.user;

import com.backend.airline_tickets_agency_management.model.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUserName(String username);

//    Optional<User> findByEmail(String email);

//
//    @Query(value = "select * from user where user_name = ?1",nativeQuery = true)
//    User findUser(String username);

    Boolean existsByUserName(String username);
}