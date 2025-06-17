package br.com.chronustecnologia.flow_cortex_api.repositories;

import br.com.chronustecnologia.flow_cortex_api.entities.CredencialEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface JpaCredencialRepository extends JpaRepository<CredencialEntity, Long> {
    Optional<CredencialEntity> findByClientIdAndActiveTrue(String clientId);
}
