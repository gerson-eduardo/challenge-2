package com.springmasters.msauthandauto.DTO.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.springmasters.msauthandauto.DTO.RoleDTO;
import com.springmasters.msauthandauto.DTO.RoleWithUserDTO;
import com.springmasters.msauthandauto.model.Role;

@Mapper
public interface RoleMapper {
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);


    @Mapping(source = "roleUser", target = "role")
    public RoleDTO roleToRoleDTO(Role role);

    @Mapping(source = "roleUser", target = "role")
    @Mapping(source = "userRole.name", target = "name")
    public RoleWithUserDTO roleToRoleWithUserDTO(Role role);
}
