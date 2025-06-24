package br.com.chronustecnologia.flow_cortex_api.services;

import br.com.chronustecnologia.flow_cortex_api.domain.Integracao;
import br.com.chronustecnologia.flow_cortex_api.ports.in.IntegracaoServicePort;
import br.com.chronustecnologia.flow_cortex_api.ports.out.IntegracaoRepositoryPort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IntegracaoServiceImpl implements IntegracaoServicePort {
    private final IntegracaoRepositoryPort integracaoRepository;

    public IntegracaoServiceImpl(IntegracaoRepositoryPort integracaoRepository) {
        this.integracaoRepository = integracaoRepository;
    }

    @Override
    public Integracao create(Integracao entity) {
        return null;
    }

    @Override
    public Integracao update(Integracao entity) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Integracao> list() {
        return List.of();
    }

    @Override
    public Integracao getById(Long id) {
        return null;
    }
}
