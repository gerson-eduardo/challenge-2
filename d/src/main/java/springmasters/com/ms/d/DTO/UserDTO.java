package springmasters.com.ms.d.DTO;
import java.util.Objects;

public class UserDTO {
    private String name;
    private String role;

    public UserDTO() {
    }

    public UserDTO(String name, String role) {
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

    public UserDTO name(String name) {
        setName(name);
        return this;
    }

    public UserDTO role(String role) {
        setRole(role);
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
        return Objects.equals(name, userDTO.name) && Objects.equals(role, userDTO.role);
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
