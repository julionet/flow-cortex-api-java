package br.com.chronustecnologia.flow_cortex_api.repositories;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.ports.out.CredencialRepositoryPort;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CredencialRepository implements CredencialRepositoryPort {
    private final JpaCredencialRepository credencialRepository;
    private final ModelMapper modelMapper;

    public CredencialRepository(JpaCredencialRepository credencialRepository, ModelMapper modelMapper) {
        this.credencialRepository = credencialRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Optional<Credencial> getByClientIdAndActive(String clientId) {
        return Optional.empty();
    }
}
