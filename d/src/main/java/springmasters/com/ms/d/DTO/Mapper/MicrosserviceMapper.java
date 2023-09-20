package springmasters.com.ms.d.DTO.Mapper;


import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import springmasters.com.ms.d.Consumer.Microsservice;
import springmasters.com.ms.d.Consumer.RoleWithUser;
import springmasters.com.ms.d.Consumer.User;
import springmasters.com.ms.d.DTO.MicrosserviceDTO;
import springmasters.com.ms.d.DTO.UserDTO;

@Mapper
public interface MicrosserviceMapper {
    MicrosserviceMapper INSTANCE = Mappers.getMapper(MicrosserviceMapper.class);

    //id setting in service
    @Mapping(source = "microsservice.name", target = "microsserviceName")
    @Mapping(source = "roles", target = "roles")
    public MicrosserviceDTO msToMsDTO(Microsservice microsservice, List<RoleWithUser> roles);
}
