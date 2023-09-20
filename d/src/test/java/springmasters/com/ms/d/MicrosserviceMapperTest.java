package springmasters.com.ms.d;

import org.junit.jupiter.api.Test;

import springmasters.com.ms.d.Consumer.Microsservice;
import springmasters.com.ms.d.Consumer.RoleWithUser;
import springmasters.com.ms.d.DTO.MicrosserviceDTO;
import springmasters.com.ms.d.DTO.Mapper.MicrosserviceMapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

public class MicrosserviceMapperTest {
    @Test
    public void testMsToMsDTO() {
        Microsservice microsservice = new Microsservice("ms schola d");
        List<RoleWithUser> roles = new ArrayList<>();
        RoleWithUser role = new RoleWithUser("test", "USER");        
        roles.add(role);
        MicrosserviceDTO microsserviceDTO = MicrosserviceMapper.INSTANCE.msToMsDTO(microsservice, roles);
        assertEquals(microsservice.getName(), microsserviceDTO.getMicrosserviceName());        
        assertEquals(role, microsserviceDTO.getroles().get(0));
    }
}
