package com.springmasters.msauthandauto.DTO.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.springmasters.msauthandauto.DTO.UserDTO;
import com.springmasters.msauthandauto.DTO.UserDTOReturn;
import com.springmasters.msauthandauto.model.User;

@Mapper
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    @Mapping(source = "userRoles", target = "userRoles")
    UserDTO userToUserDTO(User user);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "email", target = "email")
    UserDTOReturn userToUserDTOReturn(User user);
}
