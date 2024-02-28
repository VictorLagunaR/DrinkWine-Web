package com.drinkwine.drinkwine.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.drinkwine.drinkwine.model.User;
import com.drinkwine.drinkwine.service.UserService;

@RestController
@RequestMapping("/user")
public class RegisterUserController {

    // @GetMapping("/backoffice/register-user")
    // public String cadastrarUsuario(User user, Model model) {
    // return "/cadastrar-usuario";
    // }
    @Autowired
    private UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public User save(User user) {
        return userService.save(user);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<User> listUser() {
        return userService.listUser();
    }

    @GetMapping("/{idUser}")
    @ResponseStatus(HttpStatus.OK)
    public User buscarOptionalUser(@PathVariable("idUser") Long idUser) {
        return userService.buscarOptional(idUser)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{idUser}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable("idUser") Long idUser) {
        userService.buscarOptional(idUser)
                .map(user -> {
                    userService.deleteById(idUser);
                    return Void.TYPE;
                }).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado"));
    }

    @GetMapping("/listar-nomes-usuarios")
    public ResponseEntity<List<String>> listarNomesUsuarios() {
        List<User> usuarios = userService.listUser();
        List<String> nomes = usuarios.stream().map(User::getNameUser).collect(Collectors.toList());
        return ResponseEntity.ok().body(nomes);
    }

    @GetMapping("/search")
    public List<User> searchUserByName(@RequestParam String nameUser) {
        return userService.findUserByName(nameUser);
    }

}
