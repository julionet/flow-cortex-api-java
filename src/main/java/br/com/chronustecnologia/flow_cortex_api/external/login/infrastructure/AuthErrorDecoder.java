package br.com.chronustecnologia.flow_cortex_api.external.login.infrastructure;

import br.com.chronustecnologia.flow_cortex_api.external.login.domain.AuthenticationException;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.ErrorResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AuthErrorDecoder implements ErrorDecoder {

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public Exception decode(String methodKey, Response response) {
        try {
            if (response.status() >= 400 && response.status() < 500) {
                String responseBody = Util.toString(response.body().asReader(StandardCharsets.UTF_8));
                ErrorResponse errorResponse = objectMapper.readValue(responseBody, ErrorResponse.class);
                return new AuthenticationException(errorResponse.getMessage());
            }

            return new AuthenticationException("Erro interno do servidor");
        } catch (IOException e) {
            return new AuthenticationException("Erro ao processar resposta de erro", e);
        }
    }
}
