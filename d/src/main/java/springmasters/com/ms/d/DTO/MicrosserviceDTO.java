package springmasters.com.ms.d.DTO;

import java.util.List;
import java.util.Objects;

public class MicrosserviceDTO {
    private Integer microsserviceId;
    private String microsserviceName;
    private List<UserDTO> users;


    public MicrosserviceDTO() {
    }

    public MicrosserviceDTO(Integer microsserviceId, String microsserviceName, List<UserDTO> users) {
        this.microsserviceId = microsserviceId;
        this.microsserviceName = microsserviceName;
        this.users = users;
    }

    public Integer getMicrosserviceId() {
        return this.microsserviceId;
    }

    public void setMicrosserviceId(Integer microsserviceId) {
        this.microsserviceId = microsserviceId;
    }

    public String getMicrosserviceName() {
        return this.microsserviceName;
    }

    public void setMicrosserviceName(String microsserviceName) {
        this.microsserviceName = microsserviceName;
    }

    public List<UserDTO> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    public MicrosserviceDTO microsserviceId(Integer microsserviceId) {
        setMicrosserviceId(microsserviceId);
        return this;
    }

    public MicrosserviceDTO microsserviceName(String microsserviceName) {
        setMicrosserviceName(microsserviceName);
        return this;
    }

    public MicrosserviceDTO users(List<UserDTO> users) {
        setUsers(users);
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
        return Objects.equals(microsserviceId, microsserviceDTO.microsserviceId) && Objects.equals(microsserviceName, microsserviceDTO.microsserviceName) && Objects.equals(users, microsserviceDTO.users);
    }

    @Override
    public int hashCode() {
        return Objects.hash(microsserviceId, microsserviceName, users);
    }

    @Override
    public String toString() {
        return "{" +
            " microsserviceId='" + getMicrosserviceId() + "'" +
            ", microsserviceName='" + getMicrosserviceName() + "'" +
            ", users='" + getUsers() + "'" +
            "}";
    }
    
}
