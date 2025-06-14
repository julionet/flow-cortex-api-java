package br.com.chronustecnologia.flow_cortex_api.controller;

import br.com.chronustecnologia.flow_cortex_api.dto.AppResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/app")
@Tag(name = "App", description = "API para gerenciamento da aplicação")
public class AppController {

    @Operation(
            summary = "Listar todos os itens",
            description = "Retorna uma lista com todos os itens disponíveis no sistema"
    )
    @ApiResponses(value = {
            @ApiResponse(
                    responseCode = "200",
                    description = "Lista todas aplicações",
                    content = @Content(
                            mediaType = "application/json",
                            array = @ArraySchema(schema = @Schema(implementation = AppResponse.class))
                    )
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Erro interno do servidor",
                    content = @Content
            )
    })
    @GetMapping
    public List<AppResponse> all() {
        return List.of(new AppResponse("Mensagem de teste"));
    }
}
