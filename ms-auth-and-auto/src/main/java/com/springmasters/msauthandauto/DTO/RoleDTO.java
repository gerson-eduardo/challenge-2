package com.springmasters.msauthandauto.DTO;
import java.util.Objects;

public class RoleDTO {
    private String role;


    public RoleDTO() {
    }

    public RoleDTO(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RoleDTO role(String role) {
        setRole(role);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoleDTO)) {
            return false;
        }
        RoleDTO roleDTO = (RoleDTO) o;
        return Objects.equals(role, roleDTO.role);
    }

    @Override
    public String toString() {
        return "{" +
            " role='" + getRole() + "'" +
            "}";
    }
    
}
