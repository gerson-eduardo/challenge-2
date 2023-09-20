package com.springmasters.msauthandauto.DTO;

import java.util.List;
import java.util.Objects;

public class UserDTO {
    private String name;
    private String email;
    private List<MicrosserviceDTO> microsservices;


    public UserDTO() {
    }

    public UserDTO(String name, String email, List<MicrosserviceDTO> microsservices) {
        this.name = name;
        this.email = email;
        this.microsservices = microsservices;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<MicrosserviceDTO> getMicrosservices() {
        return this.microsservices;
    }

    public void setmicrosservices(List<MicrosserviceDTO> microsservices) {
        this.microsservices = microsservices;
    }

    public UserDTO name(String name) {
        setName(name);
        return this;
    }

    public UserDTO email(String email) {
        setEmail(email);
        return this;
    }

    public UserDTO microsservices(List<MicrosserviceDTO> microsservices) {
        setmicrosservices(microsservices);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDTO)) {
            return false;
        }
        UserDTO userDTO = (UserDTO) o;
        return Objects.equals(name, userDTO.name) && Objects.equals(email, userDTO.email) && Objects.equals(microsservices, userDTO.microsservices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, microsservices);
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +
                ", microsservices='" + getMicrosservices() + "'" +
                "}";
    }

}
