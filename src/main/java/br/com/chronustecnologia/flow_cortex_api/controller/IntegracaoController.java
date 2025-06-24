package br.com.chronustecnologia.flow_cortex_api.controller;

import br.com.chronustecnologia.flow_cortex_api.domain.Integracao;
import br.com.chronustecnologia.flow_cortex_api.dto.integracao.IntegracaoRequest;
import br.com.chronustecnologia.flow_cortex_api.dto.integracao.IntegracaoResponse;
import br.com.chronustecnologia.flow_cortex_api.mapper.IntegracaoMapper;
import br.com.chronustecnologia.flow_cortex_api.ports.in.IntegracaoServicePort;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/integracao")
@Tag(name = "Integração", description = "API para gerenciamento da dados de integração com ChatGPT")
public class IntegracaoController {
    private final IntegracaoServicePort integracaoService;
    private final IntegracaoMapper integracaoMapper;

    public IntegracaoController(IntegracaoServicePort integracaoService, IntegracaoMapper integracaoMapper) {
        this.integracaoService = integracaoService;
        this.integracaoMapper = integracaoMapper;
    }

    @Operation(
            summary = "Inserir um nova integração com ChatGPT",
            description = "Insere uma nova configuração para integração com ChatGPT"
    )
    @PostMapping
    public ResponseEntity<IntegracaoResponse> post(IntegracaoRequest request) {
        Integracao response = integracaoService.create(integracaoMapper.dtoToDomain(request));
        return ResponseEntity.ok(integracaoMapper.domainToDto(response));
    }

    @Operation(
            summary = "Alterar uma integração com ChatGPT",
            description = "Altera uma configuração para integração com ChatGPT"
    )
    @PutMapping
    public ResponseEntity<IntegracaoResponse> put(IntegracaoRequest request) {
        Integracao response = integracaoService.update(integracaoMapper.dtoToDomain(request));
        return ResponseEntity.ok(integracaoMapper.domainToDto(response));
    }

    @Operation(
            summary = "Excluir uma integração com ChatGPT",
            description = "Exclui uma configuração para integração com ChatGPT"
    )
    @DeleteMapping("{id}")
    public ResponseEntity<?> delete(Long id) {
        integracaoService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Operation(
            summary = "Selecionar uma integração com ChatGPT",
            description = "Seleciona uma configuração para integração com ChatGPT pelo ID"
    )
    @GetMapping("{id}")
    public ResponseEntity<IntegracaoResponse> getById(Long id) {
        Integracao response = integracaoService.getById(id);
        return ResponseEntity.ok(integracaoMapper.domainToDto(response));
    }

    @Operation(
            summary = "Selecionar todas integrações com ChatGPT",
            description = "Seleciona todas configurações para integração com ChatGPT"
    )
    @GetMapping
    public ResponseEntity<List<IntegracaoResponse>> list() {
        List<IntegracaoResponse> response = integracaoService.list().stream()
                .map(integracaoMapper::domainToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok(response);
    }
}
