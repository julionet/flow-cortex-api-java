package br.com.chronustecnologia.flow_cortex_api.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@Schema(
        description = "Resposta para endpoint de aplicação",
        example = """
                {
                    "message": "mensagem de teste"
                }
                """
)
public class AppResponse {
    @Schema(
            description = "Mensagem do response",
            example = "mensagem de teste"
    )
    private String message;
}
