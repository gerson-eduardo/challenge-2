package com.springmasters.msauthandauto.DTO;

import java.util.Objects;

public class UserDTOReturn {
    private Integer id;
    private String name;
    private String email;


    public UserDTOReturn() {
    }

    public UserDTOReturn(Integer id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public UserDTOReturn id(Integer id) {
        setId(id);
        return this;
    }

    public UserDTOReturn name(String name) {
        setName(name);
        return this;
    }

    public UserDTOReturn email(String email) {
        setEmail(email);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof UserDTOReturn)) {
            return false;
        }
        UserDTOReturn userDTOReturn = (UserDTOReturn) o;
        return Objects.equals(id, userDTOReturn.id) && Objects.equals(name, userDTOReturn.name) && Objects.equals(email, userDTOReturn.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, email);
    }

    @Override
    public String toString() {
        return "{" +
                " id='" + getId() + "'" +
                ", name='" + getName() + "'" +
                ", email='" + getEmail() + "'" +
                "}";
    }

}
