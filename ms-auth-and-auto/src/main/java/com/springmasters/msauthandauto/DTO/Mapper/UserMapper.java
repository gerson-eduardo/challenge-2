package com.springmasters.msauthandauto.DTO.Mapper;

import java.util.ArrayList;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import com.springmasters.msauthandauto.DTO.MicrosserviceDTO;
import com.springmasters.msauthandauto.DTO.UserDTO;
import com.springmasters.msauthandauto.DTO.UserDTOReturn;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    
    //function to transformer a list of roles in a list of Microsservices
    default List<MicrosserviceDTO> rolesToMicrosserviceDTOList(List<Role> roles) {
        List<MicrosserviceDTO> result = new ArrayList<>();
        for(Role role : roles){
            result.add(MicroserviceMapper.INSTANCE.msTomsDTO(role.getMicroservice(), role));
        }
        return result;
    }

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(target = "microsservices", expression = "java(rolesToMicrosserviceDTOList(user.getUserRoles()))")
    UserDTO userToUserDTO(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    UserDTOReturn userToUserDTOReturn(User user);
}
