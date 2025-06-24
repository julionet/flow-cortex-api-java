package br.com.chronustecnologia.flow_cortex_api.repositories;

import br.com.chronustecnologia.flow_cortex_api.domain.Integracao;
import br.com.chronustecnologia.flow_cortex_api.entities.IntegracaoEntity;
import br.com.chronustecnologia.flow_cortex_api.mapper.IntegracaoMapper;
import br.com.chronustecnologia.flow_cortex_api.ports.out.IntegracaoRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class IntegracaoRepository implements IntegracaoRepositoryPort {
    private final JpaIntegracaoRepository integracaoRepository;
    private final IntegracaoMapper integracaoMapper;

    public IntegracaoRepository(JpaIntegracaoRepository integracaoRepository, IntegracaoMapper integracaoMapper) {
        this.integracaoRepository = integracaoRepository;
        this.integracaoMapper = integracaoMapper;
    }

    @Override
    public Integracao save(Integracao entity) {
        IntegracaoEntity integracaoEntity = integracaoRepository.save(integracaoMapper.domainToEntity(entity));
        return integracaoMapper.entityToDomain(integracaoEntity);
    }

    @Override
    public void delete(Long id) {
        integracaoRepository.deleteById(id);
    }

    @Override
    public List<Integracao> list() {
        return integracaoRepository.findAll().stream()
                .map(integracaoMapper::entityToDomain)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Integracao> getById(Long id) {
        return integracaoRepository.findById(id)
                .map(integracaoMapper::entityToDomain);
    }
}
