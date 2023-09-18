package com.springmasters.msauthandauto.DTO;

public class BindDTOReturn {
    private String email;
    private String microservice;

    public BindDTOReturn() {
    }

    public BindDTOReturn(String email, String microservice) {
        this.email = email;
        this.microservice = microservice;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMicroservice() {
        return microservice;
    }

    public void setMicroservice(String microservice) {
        this.microservice = microservice;
    }
}