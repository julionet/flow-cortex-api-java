package br.com.chronustecnologia.flow_cortex_api.mapper;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.entities.CredencialEntity;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CredencialMapper {

    CredencialMapper INSTANCE = Mappers.getMapper(CredencialMapper.class);

    CredencialEntity domainToEntity(Credencial domain);

    Credencial entityToDomain(CredencialEntity entity);
}
