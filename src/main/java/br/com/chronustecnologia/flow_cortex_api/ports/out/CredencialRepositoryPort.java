package br.com.chronustecnologia.flow_cortex_api.ports.out;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;

import java.util.Optional;

public interface CredencialRepositoryPort {
    Optional<Credencial> getByClientIdAndActive(String clientId);
    Long count();
    void save(Credencial entity);
}
