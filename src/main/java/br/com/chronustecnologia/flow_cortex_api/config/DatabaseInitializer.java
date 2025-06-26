package br.com.chronustecnologia.flow_cortex_api.config;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.ports.out.CredencialRepositoryPort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import br.com.chronustecnologia.flow_cortex_api.repositories.CredencialRepository;

@Component
public class DatabaseInitializer implements ApplicationRunner {

    private static final Logger logger = LoggerFactory.getLogger(DatabaseInitializer.class);
    private final CredencialRepositoryPort credencialRepository;

    public DatabaseInitializer(CredencialRepository credencialRepository) {
        this.credencialRepository = credencialRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        initializeCredentials();
    }

    private void initializeCredentials() {
        if (credencialRepository.count() == 0) {
            logger.info("Inicializando credenciais padrão...");

            Credencial credencial = new Credencial(null,
                    "1120969a-a1e7-4480-9cc8-c205b1a34433",
                    "f7ceb9314837e67e1a68819a8e2996e64764fffb5fe7f2fe815de1ed16a14b79",
                    "client_credentials",
                    "admin",
                    true);

            credencialRepository.save(credencial);

            logger.info("Credencial padrão criada: {}", credencial.getClientId());
        } else {
            logger.warn("Credenciais já existem no banco, pulando inicialização...");
        }
    }
}
