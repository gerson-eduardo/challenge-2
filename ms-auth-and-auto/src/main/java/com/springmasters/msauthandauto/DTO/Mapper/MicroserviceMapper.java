package com.springmasters.msauthandauto.DTO.Mapper;

import com.springmasters.msauthandauto.DTO.BindMsDTOReturn;
import com.springmasters.msauthandauto.DTO.MicrosserviceDTO;
import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.User;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MicroserviceMapper {
    MicroserviceMapper INSTANCE = Mappers.getMapper(MicroserviceMapper.class);
    @Mapping(source = "user.email", target = "email")
    @Mapping(source = "microservice.nameMicroservice", target = "microservice")
    BindMsDTOReturn msToBindMs(Microservice microservice, User user);

    @Mapping(source = "microsservice.nameMicroservice", target = "name")    
    @Mapping(source = "role.roleUser", target = "roleUser")
    MicrosserviceDTO msTomsDTO(Microservice microsservice, Role role);
}
