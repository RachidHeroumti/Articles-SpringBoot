package com.app.Articles.Dao;

import com.app.Articles.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User,Integer> {
    //User findByEmail(String email);

    boolean existsByEmail(String email);

    Optional<User> findByEmail(String email);
}
