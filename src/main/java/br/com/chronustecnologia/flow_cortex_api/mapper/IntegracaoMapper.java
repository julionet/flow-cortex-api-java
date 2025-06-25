package br.com.chronustecnologia.flow_cortex_api.mapper;

import br.com.chronustecnologia.flow_cortex_api.domain.Integracao;
import br.com.chronustecnologia.flow_cortex_api.dto.integracao.IntegracaoRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.integracao.IntegracaoResponse;
import br.com.chronustecnologia.flow_cortex_api.entities.IntegracaoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IntegracaoMapper {

    IntegracaoMapper INSTANCE = Mappers.getMapper(IntegracaoMapper.class);

    IntegracaoEntity domainToEntity(Integracao domain);

    Integracao entityToDomain(IntegracaoEntity entity);

    @Mapping(target = "nameModel", expression = "java(mapNameModel(domain))")
    IntegracaoResponse domainToDto(Integracao domain);

    @Named("mapNameModel")
    default String mapNameModel(Integracao domain) {
        if (domain.getName() == null || domain.getModel() == null) {
            return "";
        }
        return domain.getName() + " " + domain.getModel();
    }

    Integracao dtoToDomain(IntegracaoRequest dto);
}
