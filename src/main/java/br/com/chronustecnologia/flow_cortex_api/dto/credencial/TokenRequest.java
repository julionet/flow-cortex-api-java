package br.com.chronustecnologia.flow_cortex_api.dto.credencial;

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
    description = "Requisição para obtenção de token de acesso OAuth 2.0"
)
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TokenRequest {
    @Schema(
        description = "Identificador único do cliente/aplicação",
        maxLength = 255
    )
    @Size(max = 255, message = "Client ID não pode ter mais de 255 caracteres")
    private String client_id;

    @Schema(
        description = "Chave secreta do cliente (obrigatória para client_credentials e authorization_code)",
        format = "password"
    )
    @Size(max = 255, message = "Client secret não pode ter mais de 255 caracteres")
    private String client_secret;

    @Schema(
        description = "Tipo de concessão OAuth 2.0",
        allowableValues = {"client_credentials", "authorization_code", "password", "refresh_token"}
    )
    @NotBlank(message = "Grant type não informado")
    @Pattern(regexp = "^(client_credentials|password|refresh_token|authorization_code)$",
            message = "Grant type inválido")
    private String grant_type;

    @Schema(
        description = "Escopo de acesso solicitado (opcional, espaços separados)"
    )
    @Pattern(regexp = "^(read|write|admin|user:read|user:write)$",
            message = "Scope inválido")
    private String scope;
}
