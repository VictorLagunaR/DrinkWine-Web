package com.drinkwine.drinkwine.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.drinkwine.drinkwine.model.User;
import com.drinkwine.drinkwine.repository.UserRepository;

@Controller
public class LoginController {

    @Autowired
    UserRepository userRepository;

    @PostMapping("/backoffice")
    public String processLogin(User user) {
        Optional<User> optionalDbUser = userRepository.findByEmailUser(user.getEmailUser());

        if (optionalDbUser.isPresent()) {
            User dbUser = optionalDbUser.get();
            if (dbUser.getPasswordUser().equals(user.getPasswordUser())) {
                return "redirect:/backoffice/admin.html";
            }
        }

        return "backoffice/admin.html";
    }
}