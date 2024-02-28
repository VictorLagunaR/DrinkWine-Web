package com.drinkwine.drinkwine.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drinkwine.drinkwine.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameUser(String nameUser);

    Optional<User> findByEmailUser(String emailUser);
}