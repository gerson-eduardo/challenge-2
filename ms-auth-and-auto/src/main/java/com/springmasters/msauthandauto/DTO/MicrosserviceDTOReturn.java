package com.springmasters.msauthandauto.DTO;

import java.util.Objects;

public class MicrosserviceDTOReturn {
    private String name;

    public MicrosserviceDTOReturn() {
    }

    public MicrosserviceDTOReturn(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MicrosserviceDTOReturn name(String name) {
        setName(name);
        return this;
    }



    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "{" +
            " name='" + getName() + "'" +
            "}";
    }
    
}
