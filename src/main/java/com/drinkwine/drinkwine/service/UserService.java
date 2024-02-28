package com.drinkwine.drinkwine.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drinkwine.drinkwine.model.User;
import com.drinkwine.drinkwine.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User save(User user) {
        return userRepository.save(user);
    }

    public List<User> listUser() {
        return userRepository.findAll();
    }

    public Optional<User> buscarOptional(Long idUser) {
        return userRepository.findById(idUser);
    }

    public void deleteById(Long idUser) {
        userRepository.deleteById(idUser);
    }
}
