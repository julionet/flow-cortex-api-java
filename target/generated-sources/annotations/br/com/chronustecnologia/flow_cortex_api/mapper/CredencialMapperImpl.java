package br.com.chronustecnologia.flow_cortex_api.mapper;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.entities.CredencialEntity;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-24T23:32:47-0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.6 (Amazon.com Inc.)"
)
@Component
public class CredencialMapperImpl implements CredencialMapper {

    @Override
    public CredencialEntity domainToEntity(Credencial domain) {
        if ( domain == null ) {
            return null;
        }

        CredencialEntity credencialEntity = new CredencialEntity();

        credencialEntity.setId( domain.getId() );
        credencialEntity.setClientId( domain.getClientId() );
        credencialEntity.setClientSecret( domain.getClientSecret() );
        credencialEntity.setGrantTypes( domain.getGrantTypes() );
        credencialEntity.setScopes( domain.getScopes() );
        credencialEntity.setActive( domain.getActive() );

        return credencialEntity;
    }

    @Override
    public Credencial entityToDomain(CredencialEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Credencial credencial = new Credencial();

        credencial.setId( entity.getId() );
        credencial.setClientId( entity.getClientId() );
        credencial.setClientSecret( entity.getClientSecret() );
        credencial.setGrantTypes( entity.getGrantTypes() );
        credencial.setScopes( entity.getScopes() );
        credencial.setActive( entity.isActive() );

        return credencial;
    }
}
