package com.drinkwine.drinkwine.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.drinkwine.drinkwine.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
