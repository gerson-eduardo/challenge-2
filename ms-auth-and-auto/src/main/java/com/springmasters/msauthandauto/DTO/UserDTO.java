package com.springmasters.msauthandauto.DTO;

import java.util.List;

import com.springmasters.msauthandauto.model.Role;
import java.util.Objects;

public class UserDTO {
    private String name;
    private String email;
    private List<Role> userRoles;


    public UserDTO() {
    }

    public UserDTO(String name, String email, List<Role> userRoles) {
        this.name = name;
        this.email = email;
        this.userRoles = userRoles;
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

    public List<Role> getUserRoles() {
        return this.userRoles;
    }

    public void setUserRoles(List<Role> userRoles) {
        this.userRoles = userRoles;
    }

    public UserDTO name(String name) {
        setName(name);
        return this;
    }

    public UserDTO email(String email) {
        setEmail(email);
        return this;
    }

    public UserDTO userRoles(List<Role> userRoles) {
        setUserRoles(userRoles);
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
        return Objects.equals(name, userDTO.name) && Objects.equals(email, userDTO.email) && Objects.equals(userRoles, userDTO.userRoles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, email, userRoles);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", email='" + getEmail() + "'" +
            ", userRoles='" + getUserRoles() + "'" +
            "}";
    }
    
}
