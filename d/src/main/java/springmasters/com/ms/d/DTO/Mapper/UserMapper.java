package springmasters.com.ms.d.DTO.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import springmasters.com.ms.d.Consumer.Role;
import springmasters.com.ms.d.Consumer.User;
import springmasters.com.ms.d.DTO.UserDTO;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "user.name", target = "name")
    @Mapping(source = "role.role", target = "role")
    public UserDTO userToUserDTO(User user, Role role); 
}
