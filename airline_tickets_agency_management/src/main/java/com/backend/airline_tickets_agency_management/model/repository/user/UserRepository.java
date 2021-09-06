package com.backend.airline_tickets_agency_management.model.repository.user;

import com.backend.airline_tickets_agency_management.model.entity.user.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUserName(String username);

    Optional<User> findByEmail(String email);


    @Query(value = "select * from users where email = ?1",nativeQuery = true)
    User findUser(String email);

    Boolean existsByUserName(String username);


    Boolean existsByEmail(String email);

    @Query(value = "select count(*) from users where user_code like '%k%'",nativeQuery = true)
    int totalOfRecordKH();


    @Query(value="select * from users inner join user_roles on users.id = user_roles.user_id inner join roles on roles.id = user_roles.role_id where (:para2 = 1 AND user_name like :para1) OR (:para2 = 3 AND account_name like :para1) OR (:para2 = 2 AND user_code like :para1) OR (:para2 = 4 AND roles.id = :para3) OR (:para2 = 0) order by account_name,user_name,user_code,roles.name",nativeQuery=true)
    Page<User> findAllUserByProperty(Pageable pageable, @Param("para1") String keyWord, @Param("para2") Long property, @Param("para3") Integer roleId);

}
