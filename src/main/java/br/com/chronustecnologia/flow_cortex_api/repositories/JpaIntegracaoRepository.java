package br.com.chronustecnologia.flow_cortex_api.repositories;

import br.com.chronustecnologia.flow_cortex_api.entities.IntegracaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JpaIntegracaoRepository extends JpaRepository<IntegracaoEntity, Long> {
}
