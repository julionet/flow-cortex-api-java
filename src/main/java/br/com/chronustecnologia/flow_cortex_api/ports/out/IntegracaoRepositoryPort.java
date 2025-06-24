package br.com.chronustecnologia.flow_cortex_api.ports.out;

import br.com.chronustecnologia.flow_cortex_api.domain.Integracao;

import java.util.List;
import java.util.Optional;

public interface IntegracaoRepositoryPort {
    Integracao save(Integracao entity);
    void delete(Long id);
    List<Integracao> list();
    Optional<Integracao> getById(Long id);
}
