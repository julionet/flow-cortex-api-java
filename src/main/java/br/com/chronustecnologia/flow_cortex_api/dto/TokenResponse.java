package br.com.chronustecnologia.flow_cortex_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
    name = "TokenResponse",
    description = "Resposta contendo o token de acesso OAuth 2.0 e informações relacionadas"
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TokenResponse {
    @Schema(
        description = "Token de acesso JWT para autenticação nas APIs"
    )
    @JsonProperty("access_token")
    private String accessToken;

    @Schema(
        description = "Tipo do token (sempre 'Bearer' para JWT)",
        defaultValue = "Bearer"
    )@JsonProperty("token_type")
    private String tokenType;

    @Schema(
        description = "Tempo de vida do token em segundos",
        minimum = "1",
        maximum = "86400"
    )
    @JsonProperty("expires_in")
    private Long expiresIn;

    @Schema(
        description = "Escopo de acesso concedido (pode ser diferente do solicitado)"
    )
    @JsonProperty("scope")
    private String scope;
}
