package br.com.chronustecnologia.flow_cortex_api.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Schema(description = "Resposta de erro padronizada da API")
public class ErrorResponse {
    @Schema(description = "Data e hora do erro", example = "2024-06-13T10:30:00")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;

    @Schema(description = "Código de status HTTP", example = "404")
    private int status;

    @Schema(description = "Nome do erro HTTP", example = "Not Found")
    private String error;

    @Schema(description = "Mensagem de erro", example = "Recurso não encontrado")
    private String message;

    @Schema(description = "Caminho da requisição", example = "/api/app/123")
    private String path;

    @Schema(description = "Detalhes adicionais do erro")
    private Map<String, Object> details;
}
