package br.com.chronustecnologia.flow_cortex_api.controller;

import br.com.chronustecnologia.flow_cortex_api.external.login.application.AuthenticationUseCase;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginRequest;
import br.com.chronustecnologia.flow_cortex_api.external.login.domain.LoginResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/app")
public class AppController {
    private final AuthenticationUseCase authenticationUseCase;

    public AppController(AuthenticationUseCase authenticationUseCase) {
        this.authenticationUseCase = authenticationUseCase;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        var response = authenticationUseCase.login(request.getUsername(), request.getPassword());
        return ResponseEntity.ok(response);
    }
}
