package br.com.chronustecnologia.flow_cortex_api.repositories;

import br.com.chronustecnologia.flow_cortex_api.entities.CredencialEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface JpaCredencialRepository extends JpaRepository<CredencialEntity, Long> {
    Optional<CredencialEntity> findByClientIdAndActiveTrue(String clientId);
}
