package springmasters.com.ms.d.Consumer;
import java.util.Objects;

public class RoleWithUser {
    private String name;
    private String role;


    public RoleWithUser() {
    }

    public RoleWithUser(String name, String role) {
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

    public RoleWithUser name(String name) {
        setName(name);
        return this;
    }

    public RoleWithUser role(String role) {
        setRole(role);
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof RoleWithUser)) {
            return false;
        }
        RoleWithUser roleWithUser = (RoleWithUser) o;
        return Objects.equals(name, roleWithUser.name) && Objects.equals(role, roleWithUser.role);
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
