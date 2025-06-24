package br.com.chronustecnologia.flow_cortex_api.config;

import br.com.chronustecnologia.flow_cortex_api.mapper.CredencialMapper;
import br.com.chronustecnologia.flow_cortex_api.mapper.IntegracaoMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CredencialMapper credencialMapper() {
        return Mappers.getMapper(CredencialMapper.class);
    }

    @Bean
    public IntegracaoMapper integracaoMapper() {
        return Mappers.getMapper(IntegracaoMapper.class);
    }
}
