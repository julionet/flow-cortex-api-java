package br.com.chronustecnologia.flow_cortex_api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(
        name = "TokenRequest",
        description = "Requisição para obtenção de token de acesso OAuth 2.0",
        example = """
        {
            "grant_type": "client_credentials",
            "client_id": "my-client-app",
            "client_secret": "my-secret-key",
            "scope": "read write"
        }
        """
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TokenRequest {
    @Schema(
            description = "Identificador único do cliente/aplicação",
            example = "my-client-app",
            maxLength = 255
    )
    @JsonProperty("client_id")
    @Size(max = 255, message = "Client ID não pode ter mais de 255 caracteres")
    private String clientId;

    @Schema(
            description = "Chave secreta do cliente (obrigatória para client_credentials e authorization_code)",
            example = "my-secret-key",
            format = "password"
    )
    @JsonProperty("client_secret")
    @Size(max = 255, message = "Client secret não pode ter mais de 255 caracteres")
    private String clientSecret;

    @Schema(
            description = "Tipo de concessão OAuth 2.0",
            example = "client_credentials",
            allowableValues = {"client_credentials", "authorization_code", "password", "refresh_token"}
    )
    @JsonProperty("grant_type")
    @NotBlank(message = "Grant type não informado")
    @Pattern(regexp = "^(client_credentials|password|refresh_token|authorization_code)$",
            message = "Grant type inválido")
    private String grantType;

    @Schema(
            description = "Escopo de acesso solicitado (opcional, espaços separados)",
            example = "read write admin user:read user:write"
    )
    @JsonProperty("scope")
    @Pattern(regexp = "^(read|write|admin|user:read|user:write)$",
            message = "Scope inválido")
    private String scope;
}
