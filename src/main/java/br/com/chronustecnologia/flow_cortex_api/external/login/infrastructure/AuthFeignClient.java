package br.com.chronustecnologia.flow_cortex_api.external.login.infrastructure;

import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(
        name = "auth-service",
        url = "${app.auth.service.url:http://localhost:8000}",
        configuration = AuthFeignConfiguration.class
)
public interface AuthFeignClient {
    @PostMapping(value = "/api/v1/auth/login", consumes = "application/x-www-form-urlencoded")
    LoginResponse login(
            @RequestBody MultiValueMap<String, String> formData
    );
}
