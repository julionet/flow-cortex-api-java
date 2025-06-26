package br.com.chronustecnologia.flow_cortex_api.services;

import br.com.chronustecnologia.flow_cortex_api.domain.Integracao;
import br.com.chronustecnologia.flow_cortex_api.exceptions.ResourceNotFoundException;
import br.com.chronustecnologia.flow_cortex_api.mapper.IntegracaoMapper;
import br.com.chronustecnologia.flow_cortex_api.ports.in.IntegracaoServicePort;
import br.com.chronustecnologia.flow_cortex_api.ports.out.IntegracaoRepositoryPort;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class IntegracaoServiceImpl implements IntegracaoServicePort {
    private final IntegracaoRepositoryPort integracaoRepository;
    private final IntegracaoMapper integracaoMapper;

    public IntegracaoServiceImpl(IntegracaoRepositoryPort integracaoRepository, IntegracaoMapper integracaoMapper) {
        this.integracaoRepository = integracaoRepository;
        this.integracaoMapper = integracaoMapper;
    }

    @Override
    public Integracao create(Integracao entity) {
        entity.setCreatedAt(LocalDateTime.now());
        entity.setUpdatedAt(LocalDateTime.now());
        return integracaoRepository.save(entity);
    }

    @Override
    public Integracao update(Integracao entity) {
        Integracao newEntity = integracaoRepository.getById(entity.getId())
                .orElseThrow(() -> new ResourceNotFoundException("Integração não encontrada"));

        integracaoMapper.updateEntity(newEntity, entity);
        newEntity.setUpdatedAt(LocalDateTime.now());
        return integracaoRepository.save(newEntity);
    }

    @Override
    public void delete(Long id) {
        integracaoRepository.delete(id);
    }

    @Override
    public List<Integracao> list() {
        return integracaoRepository.list();
    }

    @Override
    public Integracao getById(Long id) {
        return integracaoRepository.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Integração não encontrada"));
    }
}
