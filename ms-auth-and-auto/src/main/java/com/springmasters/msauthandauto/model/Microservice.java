package com.springmasters.msauthandauto.model;

import jakarta.persistence.Entity;

@Entity
public class Microservice {
    int id;
    String nameMicroservice;

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
