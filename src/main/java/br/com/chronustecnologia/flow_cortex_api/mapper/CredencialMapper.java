package br.com.chronustecnologia.flow_cortex_api.mapper;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.entities.CredencialEntity;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CredencialMapper {
    CredencialEntity domainToEntity(Credencial domain);

    Credencial entityToDomain(CredencialEntity entity);
}
