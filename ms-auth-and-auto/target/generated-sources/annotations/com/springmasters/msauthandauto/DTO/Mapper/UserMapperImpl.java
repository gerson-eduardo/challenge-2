package com.springmasters.msauthandauto.DTO.Mapper;

import com.springmasters.msauthandauto.DTO.UserDTO;
import com.springmasters.msauthandauto.DTO.UserDTOReturn;
import com.springmasters.msauthandauto.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-20T20:01:38-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.name( user.getName() );
        userDTO.email( user.getEmail() );

        userDTO.microsservices( rolesToMicrosserviceDTOList(user.getUserRoles()) );

        return userDTO;
    }

    @Override
    public UserDTOReturn userToUserDTOReturn(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTOReturn userDTOReturn = new UserDTOReturn();

        userDTOReturn.id( user.getId() );
        userDTOReturn.name( user.getName() );
        userDTOReturn.email( user.getEmail() );

        return userDTOReturn;
    }
}
