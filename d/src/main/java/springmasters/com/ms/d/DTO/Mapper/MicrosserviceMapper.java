package springmasters.com.ms.d.DTO.Mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import springmasters.com.ms.d.Consumer.Microsservice;
import springmasters.com.ms.d.DTO.MicrosserviceDTO;

@Mapper
public interface MicrosserviceMapper {
    MicrosserviceMapper INSTANCE = Mappers.getMapper(MicrosserviceMapper.class);

    @Mapping(source = "name", target = "microsserviceName")
    public MicrosserviceDTO msToMsDTO(Microsservice microsservice);
}
