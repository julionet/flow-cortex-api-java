package br.com.chronustecnologia.flow_cortex_api.dto.integracao;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Requisição de dados de integração")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IntegracaoRequest {
    @Schema(description = "Identificação da integração")
    private Long id;

    @Schema(description = "Nome da integração")
    @NotBlank(message = "Nome não informado")
    @Size(max = 100, message = "Nome não pode ter mais de 100 caracteres")
    private String name;

    @Schema(description = "Chave da API da OpenAI para autenticação")
    @NotBlank(message = "Apikey não informada")
    @Size(max = 100, message = "Apikey não pode ter mais de 100 caracteres")
    @JsonProperty("api_key")
    private String apiKey;

    @Schema(description = "ID da organização na OpenAI (opcional)")
    @Size(max = 50, message = "ID da organização não pode ter mais de 50 caracteres")
    @JsonProperty("organization_id")
    private String organizationId;

    @Schema(description = "Modelo do ChatGPT a ser utilizado (ex: gpt-3.5-turbo, gpt-4)")
    @NotBlank(message = "Modelo do ChatGPT não informada")
    private String model;

    @Schema(description = "Controle de aleatoriedade das respostas (0.0 a 2.0)")
    @DecimalMin(value = "0.0", message = "Temperatura deve ser maior ou igual a 0.0")
    @DecimalMax(value = "2.0", message = "Temperatura deve ser menor ou igual a 2.0")
    private double temperature;

    @Schema(description = "Limite máximo de tokens na resposta")
    @Min(value = 0, message = "Limite máximo de tokens deve ser maior ou igual a 0")
    @JsonProperty("max_tokens")
    private int maxTokens;

    @Schema(description = "Diversidade do texto (nucleation sampling)")
    @DecimalMin(value = "0.0", message = "Diversidade do texto deve ser maior ou igual a 0.0")
    @JsonProperty("top_p")
    private double topP;

    @Schema(description = "Penalidade para repetição de frequência")
    @DecimalMin(value = "0.0", message = "Penalidade para repetição de frequência deve ser maior ou igual a 0.0")
    @JsonProperty("frequency_penalty")
    private double frequencyPenalty;

    @Schema(description = "Penalidade para repetição de tópicos")
    @DecimalMin(value = "0.0", message = "Penalidade para repetição de tópicos deve ser maior ou igual a 0.0")
    @JsonProperty("presence_penalty")
    private double presencePenalty;

    @Schema(description = "Tempo limite para resposta da API")
    @Min(value = 0, message = "Tempo limite deve ser maior ou igual a 0")
    @JsonProperty("timeout_seconds")
    private int timeoutSeconds;

    @Schema(description = "Status da configuração (ativo/inativo)")
    private boolean active;
}
