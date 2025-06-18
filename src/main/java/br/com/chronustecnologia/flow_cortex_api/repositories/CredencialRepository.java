package br.com.chronustecnologia.flow_cortex_api.repositories;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.mapper.CredencialMapper;
import br.com.chronustecnologia.flow_cortex_api.ports.out.CredencialRepositoryPort;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CredencialRepository implements CredencialRepositoryPort {
    private final JpaCredencialRepository credencialRepository;
    private final CredencialMapper credencialMapper;

    public CredencialRepository(JpaCredencialRepository credencialRepository, CredencialMapper credencialMapper) {
        this.credencialRepository = credencialRepository;
        this.credencialMapper = credencialMapper;
    }

    @Override
    public Optional<Credencial> getByClientIdAndActive(String clientId) {
        return credencialRepository.findByClientIdAndActiveTrue(clientId)
                .map(credencialMapper::entityToDomain);
    }

    @Override
    public Long count() {
        return credencialRepository.count();
    }

    @Override
    public void save(Credencial entity) {
        credencialRepository.save(credencialMapper.domainToEntity(entity));
    }
}
