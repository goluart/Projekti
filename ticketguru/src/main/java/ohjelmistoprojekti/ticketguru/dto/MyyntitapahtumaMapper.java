package ohjelmistoprojekti.ticketguru.dto;

import org.mapstruct.Mapper;

import ohjelmistoprojekti.ticketguru.domain.Myyntitapahtuma;

import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MyyntitapahtumaMapper {

    MyyntitapahtumaMapper INSTANCE = Mappers.getMapper(MyyntitapahtumaMapper.class);

    @Mapping(source = "myyntitapahtumaId", target = "myyntitapahtumaId")
    MyyntitapahtumaDTO myyntitapahtumaToMyyntitapahtumaDTO(Myyntitapahtuma myyntitapahtuma);

    @Mapping(source = "myyntitapahtumaId", target = "myyntitapahtumaId")
    Myyntitapahtuma myyntitapahtumaDTOToMyyntitapahtuma(MyyntitapahtumaDTO dto);

}
