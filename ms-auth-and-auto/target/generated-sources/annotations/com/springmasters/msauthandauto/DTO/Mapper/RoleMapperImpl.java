package com.springmasters.msauthandauto.DTO.Mapper;

import com.springmasters.msauthandauto.DTO.RoleDTO;
import com.springmasters.msauthandauto.DTO.RoleWithUserDTO;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-20T20:01:38-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class RoleMapperImpl implements RoleMapper {

    @Override
    public RoleDTO roleToRoleDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleDTO roleDTO = new RoleDTO();

        if ( role.getRoleUser() != null ) {
            roleDTO.role( role.getRoleUser().name() );
        }

        return roleDTO;
    }

    @Override
    public RoleWithUserDTO roleToRoleWithUserDTO(Role role) {
        if ( role == null ) {
            return null;
        }

        RoleWithUserDTO roleWithUserDTO = new RoleWithUserDTO();

        if ( role.getRoleUser() != null ) {
            roleWithUserDTO.role( role.getRoleUser().name() );
        }
        roleWithUserDTO.name( roleUserRoleName( role ) );

        return roleWithUserDTO;
    }

    private String roleUserRoleName(Role role) {
        if ( role == null ) {
            return null;
        }
        User userRole = role.getUserRole();
        if ( userRole == null ) {
            return null;
        }
        String name = userRole.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
