package com.springmasters.msauthandauto.DTO;

import com.springmasters.msauthandauto.model.Role.userRole;
import java.util.Objects;

public class MicrosserviceDTO {
    private String name;
    private userRole roleUser;


    public MicrosserviceDTO() {
    }

    public MicrosserviceDTO(String name, userRole roleUser) {
        this.name = name;
        this.roleUser = roleUser;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public userRole getRoleUser() {
        return this.roleUser;
    }

    public void setRoleUser(userRole roleUser) {
        this.roleUser = roleUser;
    }

    public MicrosserviceDTO name(String name) {
        setName(name);
        return this;
    }

    public MicrosserviceDTO roleUser(userRole roleUser) {
        setRoleUser(roleUser);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof MicrosserviceDTO)) {
            return false;
        }
        MicrosserviceDTO microsserviceDTO = (MicrosserviceDTO) o;
        return Objects.equals(name, microsserviceDTO.name) && Objects.equals(roleUser, microsserviceDTO.roleUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, roleUser);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", roleUser='" + getRoleUser() + "'" +
            "}";
    }
    
}
