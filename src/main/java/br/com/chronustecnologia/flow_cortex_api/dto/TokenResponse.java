package br.com.chronustecnologia.flow_cortex_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        name = "TokenResponse",
        description = "Resposta contendo o token de acesso OAuth 2.0 e informações relacionadas",
        example = """
        {
            "access_token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9...",
            "token_type": "Bearer",
            "expires_in": 3600,
            "scope": "read write"
        }
        """
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TokenResponse {
    @Schema(
            description = "Token de acesso JWT para autenticação nas APIs",
            example = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c"
    )
    @JsonProperty("access_token")
    private String accessToken;

    @Schema(
            description = "Tipo do token (sempre 'Bearer' para JWT)",
            example = "Bearer",
            defaultValue = "Bearer"
    )@JsonProperty("token_type")
    private String tokenType;

    @Schema(
            description = "Tempo de vida do token em segundos",
            example = "3600",
            minimum = "1",
            maximum = "86400"
    )
    @JsonProperty("expires_in")
    private Long expiresIn;

    @Schema(
            description = "Escopo de acesso concedido (pode ser diferente do solicitado)",
            example = "read write"
    )
    @JsonProperty("scope")
    private String scope;
}
