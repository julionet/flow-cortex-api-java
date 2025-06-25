package br.com.chronustecnologia.flow_cortex_api.external.login.infrastructure;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthFeignConfiguration {

    @Bean
    public AuthErrorDecoder errorDecoder() {
        return new AuthErrorDecoder();
    }

    @Bean
    public Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Bean
    public Retryer retryer() {
        return new Retryer.Default(1000, 2000, 3);
    }
}
