package com.springmasters.msauthandauto.model;
import java.util.Objects;

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
    private User user;   
    
    @ManyToOne
    @JoinColumn(name = "microservice_id")
    private Microservice microservice;

    @Enumerated(EnumType.STRING)
    private userRole roleUser;

    public enum userRole{
     Admin,
     User   
    }

    public User getUser() {
        return this.user;
    }                                                                                                           

    public void setIdUSer(User user) {
        this.user = user;
    }

    public Microservice getMicrosservice() {
        return this.microservice;
    }

    public void setMicrosservice(Microservice microsservice) {
        this.microservice = microsservice;
    }

    public userRole getRoleUser() {
        return this.roleUser;
    }

    public void setRoleUser(userRole roleUser) {
        this.roleUser = roleUser;
    }
}
