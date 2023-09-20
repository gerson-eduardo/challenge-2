package springmasters.com.ms.d.DTO;

import java.util.List;
import java.util.Objects;

import springmasters.com.ms.d.Consumer.RoleWithUser;

public class MicrosserviceDTO {
    private Integer microsserviceId;
    private String microsserviceName;
    private List<RoleWithUser> roles;


    public MicrosserviceDTO() {
    }

    public MicrosserviceDTO(Integer microsserviceId, String microsserviceName, List<RoleWithUser> roles) {
        this.microsserviceId = microsserviceId;
        this.microsserviceName = microsserviceName;
        this.roles = roles;
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

    public List<RoleWithUser> getroles() {
        return this.roles;
    }

    public void setroles(List<RoleWithUser> roles) {
        this.roles = roles;
    }

    public MicrosserviceDTO microsserviceId(Integer microsserviceId) {
        setMicrosserviceId(microsserviceId);
        return this;
    }

    public MicrosserviceDTO microsserviceName(String microsserviceName) {
        setMicrosserviceName(microsserviceName);
        return this;
    }

    public MicrosserviceDTO roles(List<RoleWithUser> roles) {
        setroles(roles);
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
        return Objects.equals(microsserviceId, microsserviceDTO.microsserviceId) && Objects.equals(microsserviceName, microsserviceDTO.microsserviceName) && Objects.equals(roles, microsserviceDTO.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(microsserviceId, microsserviceName, roles);
    }

    @Override
    public String toString() {
        return "{" +
            " microsserviceId='" + getMicrosserviceId() + "'" +
            ", microsserviceName='" + getMicrosserviceName() + "'" +
            ", roles='" + getroles() + "'" +
            "}";
    }
    
}
