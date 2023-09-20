package springmasters.com.ms.d.DTO.Mapper;


import java.util.ArrayList;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import springmasters.com.ms.d.Consumer.Microsservice;
import springmasters.com.ms.d.Consumer.Role;
import springmasters.com.ms.d.Consumer.User;
import springmasters.com.ms.d.DTO.MicrosserviceDTO;
import springmasters.com.ms.d.DTO.UserDTO;

@Mapper
public interface MicrosserviceMapper {
    MicrosserviceMapper INSTANCE = Mappers.getMapper(MicrosserviceMapper.class);

    default List<UserDTO> convertRoleInUserDTO(List<Role> roles, User user){
        List<UserDTO> userDTO = new ArrayList<>();
        for(Role role: roles){
            userDTO.add(UserMapper.INSTANCE.userToUserDTO(user, role));
        }
        return userDTO;
    }

    //id setting in service
    @Mapping(source = "name", target = "microsserviceName")
    @Mapping(target = "users", expression = "java(convertRoleInUserDTO(roles, user))")
    public MicrosserviceDTO msToMsDTO(Microsservice microsservice, User user, List<Role> roles);
}
