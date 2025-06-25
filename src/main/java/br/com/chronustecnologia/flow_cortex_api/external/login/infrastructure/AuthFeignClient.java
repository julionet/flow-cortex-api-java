package br.com.chronustecnologia.flow_cortex_api.external.login.infrastructure;

import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginRequest;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "auth-service",
        url = "${app.auth.service.url:http://localhost:8000}",
        configuration = AuthFeignConfiguration.class
)
public interface AuthFeignClient {
    @PostMapping("/api/v1/auth/login")
    LoginResponse login(@RequestBody LoginRequest loginRequest);
}
