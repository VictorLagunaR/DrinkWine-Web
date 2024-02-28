package com.drinkwine.drinkwine.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.drinkwine.drinkwine.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByNameUser(String nameUser);
}
