package br.com.chronustecnologia.flow_cortex_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class FlowCortextApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlowCortextApiApplication.class, args);
	}

}
