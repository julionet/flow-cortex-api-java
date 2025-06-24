package br.com.chronustecnologia.flow_cortex_api.ports.in;

import br.com.chronustecnologia.flow_cortex_api.domain.Integracao;

import java.util.List;

public interface IntegracaoServicePort {
    Integracao create(Integracao entity);
    Integracao update(Integracao entity);
    void delete(Long id);
    List<Integracao> list();
    Integracao getById(Long id);
}
