package br.com.chronustecnologia.flow_cortex_api.config;

import br.com.chronustecnologia.flow_cortex_api.mapper.CredencialMapper;
import org.mapstruct.factory.Mappers;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public CredencialMapper credencialMapper() {
        return Mappers.getMapper(CredencialMapper.class);
    }
}
