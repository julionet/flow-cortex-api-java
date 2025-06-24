package br.com.chronustecnologia.flow_cortex_api.mapper;

import br.com.chronustecnologia.flow_cortex_api.domain.Integracao;
import br.com.chronustecnologia.flow_cortex_api.dto.integracao.IntegracaoRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.integracao.IntegracaoResponse;
import br.com.chronustecnologia.flow_cortex_api.entities.IntegracaoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface IntegracaoMapper {
    IntegracaoEntity domainToEntity(Integracao domain);

    Integracao entityToDomain(IntegracaoEntity entity);

    IntegracaoResponse domainToDto(Integracao domain);

    Integracao dtoToDomain(IntegracaoRequest dto);
}
