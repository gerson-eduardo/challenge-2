package springmasters.com.ms.d.Consumer;
import java.util.Objects;

public class Role {
    private String role;

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

    public String getRole() {
        return this.role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role role(String role) {
        setRole(role);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Role)) {
            return false;
        }
        Role role = (Role) o;
        return Objects.equals(role, role.role);
    }


    @Override
    public String toString() {
        return "{" +
            " role='" + getRole() + "'" +
            "}";
    }
    
}
