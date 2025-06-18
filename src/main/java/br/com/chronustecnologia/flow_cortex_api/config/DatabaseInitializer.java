package br.com.chronustecnologia.flow_cortex_api.config;

import br.com.chronustecnologia.flow_cortex_api.domain.Credencial;
import br.com.chronustecnologia.flow_cortex_api.ports.out.CredencialRepositoryPort;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import br.com.chronustecnologia.flow_cortex_api.repositories.CredencialRepository;

@Component
public class DatabaseInitializer implements ApplicationRunner {

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
            System.out.println("Inicializando credenciais padrão...");

            Credencial credencial = new Credencial(null,
                    "f7ceb9314837e67e1a68819a8e2996e64764fffb5fe7f2fe815de1ed16a14b79",
                    "1120969a-a1e7-4480-9cc8-c205b1a34433",
                    "client_credentials",
                    "admin",
                    true);

            credencialRepository.save(credencial);

            System.out.println("Credencial padrão criada: " + credencial.getClientId());
        } else {
            System.out.println("Credenciais já existem no banco, pulando inicialização...");
        }
    }
}
