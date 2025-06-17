package br.com.chronustecnologia.flow_cortex_api.controller;

import br.com.chronustecnologia.flow_cortex_api.dto.TokenRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.TokenResponse;
import br.com.chronustecnologia.flow_cortex_api.ports.in.CredencialServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@Tag(
        name = "OAuth 2.0 Authentication",
        description = "Endpoints para autenticação OAuth 2.0 com Client Credentials Grant")
public class AuthController {
    private final CredencialServicePort credencialService;

    public AuthController(CredencialServicePort credencialService) {
        this.credencialService = credencialService;
    }

    @Operation(
            summary = "Obter um novo JWT token",
            description = """
                    Gera um token JWT usando o fluxo OAuth 2.0 Client Credentials Grant.
                   \s
                    **Fluxo de autenticação:**
                    1. Cliente envia credenciais (clientId, clientSecret)
                    2. Sistema valida as credenciais
                    3. Sistema verifica os scopes permitidos para o cliente
                    4. Token JWT é gerado com os scopes validados
                   \s
                    **Scopes disponíveis:**
                    - `read`: Permissões de leitura básica
                    - `write`: Permissões de escrita
                    - `user:read`: Leitura de dados de usuários
                    - `user:write`: Escrita de dados de usuários
                    - `admin`: Permissões administrativas
                    - `order:read`: Leitura de pedidos
                    - `order:write`: Escrita de pedidos
                   """,
            operationId = "generateToken"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Token gerado com sucesso",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TokenResponse.class),
                            examples = @ExampleObject(
                                    name = "Sucesso",
                                    summary = "Token JWT gerado",
                                    value = """
                                        {
                                          "accessToken": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
                                          "tokenType": "Bearer",
                                          "expiresIn": 3600,
                                          "scope": "read user:read"
                                        }
                                        """
                            )
                    )
            ),
            @ApiResponse(
                    responseCode = "400",
                    description = "Erro na requisição - credenciais inválidas ou scopes não permitidos",
                    content = @Content(
                            mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = TokenResponse.class),
                            examples = {
                                    @ExampleObject(
                                            name = "Credenciais Inválidas",
                                            summary = "Client ID ou Secret incorretos",
                                            value = """
                                                {
                                                  "timestamp": "2024-05-15T15:25:46",
                                                  "status": 400,
                                                  "error": "Bad request",
                                                  "message": "Credenciais inválidas",
                                                  "path": "/api/auth/token",
                                                  "details": null
                                                }
                                                """
                                    ),
                                    @ExampleObject(
                                            name = "Grant Type Inválido",
                                            summary = "Grant type não suportado",
                                            value = """
                                                {
                                                  "timestamp": "2024-05-15T15:25:46",
                                                  "status": 400,
                                                  "error": "Bad request",
                                                  "message": "Grant type não suportado",
                                                  "path": "/api/auth/token",
                                                  "details": null
                                                }
                                                """
                                    ),
                                    @ExampleObject(
                                            name = "Scope Inválido",
                                            summary = "Scope não permitido para o cliente",
                                            value = """
                                                {
                                                  "timestamp": "2024-05-15T15:25:46",
                                                  "status": 400,
                                                  "error": "Bad request",
                                                  "message": "Scope não permitido para o cliente",
                                                  "path": "/api/auth/token",
                                                  "details": null
                                                }
                                                """
                                    )
                            }
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content
            )
    })
    @PostMapping(value = "/token", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<TokenResponse> token(@Valid @ModelAttribute TokenRequest request) {
        try {
            TokenResponse response = credencialService.authenticate(request);
            return ResponseEntity.ok(response);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
