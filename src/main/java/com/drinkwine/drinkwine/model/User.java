package com.drinkwine.drinkwine.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usuario")
public class User implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idUser;

    @Column(name = "nameUser", nullable = false)
    private String nameUser;

    @Column(name = "email")
    private String emailUser;

    @Column(name = "passwordUser")
    private String passwordUser;

    @Column(name = "confirmPasswordUser")
    private String confirmPasswordUser;

    @Column(name = "GenderUser")
    private String GenderUser;

}
