package com.ladakh.databanking.dao;

import com.ladakh.databanking.domain.Material;
import com.ladakh.databanking.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserDAO extends JpaRepository<User, Long> {
    @Query("select u from User u where u.userID =:userID")
    User findByUserID(@Param("userID")long user);
}
