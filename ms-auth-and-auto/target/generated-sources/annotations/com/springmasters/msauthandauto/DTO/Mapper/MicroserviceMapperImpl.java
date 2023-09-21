package com.springmasters.msauthandauto.DTO.Mapper;

import com.springmasters.msauthandauto.DTO.BindMsDTOReturn;
import com.springmasters.msauthandauto.DTO.MicrosserviceDTO;
import com.springmasters.msauthandauto.DTO.MicrosserviceDTOReturn;
import com.springmasters.msauthandauto.model.Microservice;
import com.springmasters.msauthandauto.model.Role;
import com.springmasters.msauthandauto.model.User;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-20T20:01:38-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.8 (Oracle Corporation)"
)
public class MicroserviceMapperImpl implements MicroserviceMapper {

    @Override
    public BindMsDTOReturn msToBindMs(Microservice microservice, User user) {
        if ( microservice == null && user == null ) {
            return null;
        }

        BindMsDTOReturn bindMsDTOReturn = new BindMsDTOReturn();

        if ( microservice != null ) {
            bindMsDTOReturn.setMicroservice( microservice.getNameMicroservice() );
        }
        if ( user != null ) {
            bindMsDTOReturn.setEmail( user.getEmail() );
        }

        return bindMsDTOReturn;
    }

    @Override
    public MicrosserviceDTO msTomsDTO(Microservice microsservice, Role role) {
        if ( microsservice == null && role == null ) {
            return null;
        }

        MicrosserviceDTO microsserviceDTO = new MicrosserviceDTO();

        if ( microsservice != null ) {
            microsserviceDTO.name( microsservice.getNameMicroservice() );
        }
        if ( role != null ) {
            microsserviceDTO.roleUser( role.getRoleUser() );
        }

        return microsserviceDTO;
    }

    @Override
    public MicrosserviceDTOReturn msToMsDTOReturn(Microservice microsservice) {
        if ( microsservice == null ) {
            return null;
        }

        MicrosserviceDTOReturn microsserviceDTOReturn = new MicrosserviceDTOReturn();

        microsserviceDTOReturn.name( microsservice.getNameMicroservice() );

        return microsserviceDTOReturn;
    }
}
