package br.com.chronustecnologia.flow_cortex_api.dto.integracao;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Schema(description = "Resposta de dados de integração")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IntegracaoResponse {
    @Schema(description = "Identificação da integração")
    private Long id;

    @Schema(description = "Nome da integração")
    private String name;

    @Schema(description = "Chave da API da OpenAI para autenticação")
    private String apiKey;

    @Schema(description = "ID da organização na OpenAI (opcional)")
    private String organizationId;

    @Schema(description = "Modelo do ChatGPT a ser utilizado (ex: gpt-3.5-turbo, gpt-4)")
    private String model;

    @Schema(description = "Controle de aleatoriedade das respostas (0.0 a 2.0)")
    private double temperature;

    @Schema(description = "Limite máximo de tokens na resposta")
    private int maxTokens;

    @Schema(description = "Diversidade do texto (nucleation sampling)")
    private double topP;

    @Schema(description = "Penalidade para repetição de frequência")
    private double frequencyPenalty;

    @Schema(description = "Penalidade para repetição de tópicos")
    private double presencePenalty;

    @Schema(description = "Tempo limite para resposta da API")
    private int timeoutSeconds;

    @Schema(description = "Status da configuração (ativo/inativo)")
    private boolean active;

    @Schema(description = "Nome e modelo utilizado")
    private String nameModel;
}
