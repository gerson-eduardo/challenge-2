package com.springmasters.msauthandauto.DTO.Mapper;

import com.springmasters.msauthandauto.DTO.BindDTOReturn;
import com.springmasters.msauthandauto.model.Microservice;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

public interface MicroserviceMapper {
    MicroserviceMapper INSTANCE = Mappers.getMapper(MicroserviceMapper.class);

    @Mapping(source = "email", target = "email")
    @Mapping(source = "microservice", target = "microservice")
    BindDTOReturn msToMs(Microservice microservice);
}
