package com.springmasters.msauthandauto.DTO;
import java.util.Objects;

public class RoleWithUserDTO {
    private String name;
    private String role;


    public RoleWithUserDTO() {
    }

    public RoleWithUserDTO(String name, String role) {
        this.name = name;
        this.role = role;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public RoleWithUserDTO name(String name) {
        setName(name);
        return this;
    }

    public RoleWithUserDTO role(String role) {
        setRole(role);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoleWithUserDTO)) {
            return false;
        }
        RoleWithUserDTO roleWithUserDTO = (RoleWithUserDTO) o;
        return Objects.equals(name, roleWithUserDTO.name) && Objects.equals(role, roleWithUserDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, role);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            ", role='" + getRole() + "'" +
            "}";
    }
    
}
