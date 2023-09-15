package com.springmasters.msauthandauto.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Microservice {
    @Id
    @Column(name = "microservice_id")
    private int id;
    @Column(name = "microservice_name")
    private String nameMicroservice;

    public Microservice() {
    }

    public Microservice(int id, String nameMicroservice) {
        this.id = id;
        this.nameMicroservice = nameMicroservice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMicroservice() {
        return nameMicroservice;
    }

    public void setNameMicroservice(String nameMicroservice) {
        this.nameMicroservice = nameMicroservice;
    }
}
