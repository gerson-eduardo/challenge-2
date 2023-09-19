package com.springmasters.msauthandauto.DTO;

public class BindMsDTOReturn {
    private String emailUser;
    private String nameMicroservice;

    public BindMsDTOReturn() {
    }

    public BindMsDTOReturn(String emailUser, String nameMicroservice) {
        this.emailUser = emailUser;
        this.nameMicroservice = nameMicroservice;
    }

    public String getEmail() {
        return emailUser;
    }

    public void setEmail(String emailUser) {
        this.emailUser = emailUser;
    }

    public String getMicroservice() {
        return nameMicroservice;
    }

    public void setMicroservice(String nameMicroservice) {
        this.nameMicroservice = nameMicroservice;
    }
}