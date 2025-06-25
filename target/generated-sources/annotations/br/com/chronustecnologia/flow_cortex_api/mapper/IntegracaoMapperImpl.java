package br.com.chronustecnologia.flow_cortex_api.mapper;

import br.com.chronustecnologia.flow_cortex_api.domain.Integracao;
import br.com.chronustecnologia.flow_cortex_api.dto.integracao.IntegracaoRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.integracao.IntegracaoResponse;
import br.com.chronustecnologia.flow_cortex_api.entities.IntegracaoEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-25T17:53:07-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.7 (Amazon.com Inc.)"
)
@Component
public class IntegracaoMapperImpl implements IntegracaoMapper {

    @Override
    public IntegracaoEntity domainToEntity(Integracao domain) {
        if ( domain == null ) {
            return null;
        }

        IntegracaoEntity integracaoEntity = new IntegracaoEntity();

        integracaoEntity.setId( domain.getId() );
        integracaoEntity.setName( domain.getName() );
        integracaoEntity.setApiKey( domain.getApiKey() );
        integracaoEntity.setOrganizationId( domain.getOrganizationId() );
        integracaoEntity.setModel( domain.getModel() );
        integracaoEntity.setTemperature( domain.getTemperature() );
        integracaoEntity.setMaxTokens( domain.getMaxTokens() );
        integracaoEntity.setTopP( domain.getTopP() );
        integracaoEntity.setFrequencyPenalty( domain.getFrequencyPenalty() );
        integracaoEntity.setPresencePenalty( domain.getPresencePenalty() );
        integracaoEntity.setTimeoutSeconds( domain.getTimeoutSeconds() );
        integracaoEntity.setCreatedAt( domain.getCreatedAt() );
        integracaoEntity.setUpdatedAt( domain.getUpdatedAt() );
        integracaoEntity.setActive( domain.isActive() );

        return integracaoEntity;
    }

    @Override
    public Integracao entityToDomain(IntegracaoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Integracao integracao = new Integracao();

        integracao.setId( entity.getId() );
        integracao.setName( entity.getName() );
        integracao.setApiKey( entity.getApiKey() );
        integracao.setOrganizationId( entity.getOrganizationId() );
        integracao.setModel( entity.getModel() );
        integracao.setTemperature( entity.getTemperature() );
        integracao.setMaxTokens( entity.getMaxTokens() );
        integracao.setTopP( entity.getTopP() );
        integracao.setFrequencyPenalty( entity.getFrequencyPenalty() );
        integracao.setPresencePenalty( entity.getPresencePenalty() );
        integracao.setTimeoutSeconds( entity.getTimeoutSeconds() );
        integracao.setCreatedAt( entity.getCreatedAt() );
        integracao.setUpdatedAt( entity.getUpdatedAt() );
        integracao.setActive( entity.isActive() );

        return integracao;
    }

    @Override
    public IntegracaoResponse domainToDto(Integracao domain) {
        if ( domain == null ) {
            return null;
        }

        IntegracaoResponse integracaoResponse = new IntegracaoResponse();

        integracaoResponse.setId( domain.getId() );
        integracaoResponse.setName( domain.getName() );
        integracaoResponse.setApiKey( domain.getApiKey() );
        integracaoResponse.setOrganizationId( domain.getOrganizationId() );
        integracaoResponse.setModel( domain.getModel() );
        integracaoResponse.setTemperature( domain.getTemperature() );
        integracaoResponse.setMaxTokens( domain.getMaxTokens() );
        integracaoResponse.setTopP( domain.getTopP() );
        integracaoResponse.setFrequencyPenalty( domain.getFrequencyPenalty() );
        integracaoResponse.setPresencePenalty( domain.getPresencePenalty() );
        integracaoResponse.setTimeoutSeconds( domain.getTimeoutSeconds() );
        integracaoResponse.setActive( domain.isActive() );

        integracaoResponse.setNameModel( mapNameModel(domain) );

        return integracaoResponse;
    }

    @Override
    public Integracao dtoToDomain(IntegracaoRequest dto) {
        if ( dto == null ) {
            return null;
        }

        Integracao integracao = new Integracao();

        integracao.setId( dto.getId() );
        integracao.setName( dto.getName() );
        integracao.setApiKey( dto.getApiKey() );
        integracao.setOrganizationId( dto.getOrganizationId() );
        integracao.setModel( dto.getModel() );
        integracao.setTemperature( dto.getTemperature() );
        integracao.setMaxTokens( dto.getMaxTokens() );
        integracao.setTopP( dto.getTopP() );
        integracao.setFrequencyPenalty( dto.getFrequencyPenalty() );
        integracao.setPresencePenalty( dto.getPresencePenalty() );
        integracao.setTimeoutSeconds( dto.getTimeoutSeconds() );
        integracao.setActive( dto.isActive() );

        return integracao;
    }
}
