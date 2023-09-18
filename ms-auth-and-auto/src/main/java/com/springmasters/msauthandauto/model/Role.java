package com.springmasters.msauthandauto.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    private Integer idRole;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userRole;

    public static final Integer ADMIN = 1;
    public static final Integer USER = 1;

    @ManyToOne
    @JoinColumn(name = "microservice_id")
    private Microservice microservice;

    @Enumerated(EnumType.STRING)
    private userRole roleUser;


    public Role(Integer idRole, User userRole, Microservice microservice, userRole roleUser) {
        this.idRole = idRole;
        this.userRole = userRole;
        this.microservice = microservice;
        this.roleUser = roleUser;
    }

    public Role(User userRole, Microservice microservice, userRole roleUser) {
        this.userRole = userRole;
        this.microservice = microservice;
        this.roleUser = roleUser;
    }

    public Role(User userRole, userRole roleUser) {
        this.userRole = userRole;
        this.microservice = microservice;
        this.roleUser = roleUser;
    }

    public Role() {
    }

    public enum userRole {
        ADMIN,
        USER
    }

    public Integer getIdRole() {
        return idRole;
    }

    public void setIdRole(Integer idRole) {
        this.idRole = idRole;
    }

    @JsonBackReference
    public User getUserRole() {
        return userRole;
    }

    public void setUserRole(User userRole) {
        this.userRole = userRole;
    }

    public Microservice getMicroservice() {
        return microservice;
    }

    public void setMicroservice(Microservice microservice) {
        this.microservice = microservice;
    }

    public Role.userRole getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(Role.userRole roleUser) {
        this.roleUser = roleUser;
    }
}
