package br.com.chronustecnologia.flow_cortex_api.mapper;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.entities.CredencialEntity;
import org.mapstruct.*;
import org.springframework.stereotype.Component;

@Mapper(
        componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE
)
public interface CredencialMapper {
    CredencialEntity domainToEntity(Credencial domain);

    Credencial entityToDomain(CredencialEntity entity);
}
