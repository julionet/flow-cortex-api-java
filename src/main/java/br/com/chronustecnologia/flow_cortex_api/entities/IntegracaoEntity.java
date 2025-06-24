package br.com.chronustecnologia.flow_cortex_api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "integracao")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class IntegracaoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "api_key", nullable = false, length = 100)
    private String apiKey;

    @Column(name = "organization_id", nullable = true, length = 50)
    private String organizationId;

    @Column(name = "model", nullable = false, length = 50)
    private String model;

    @Column(name = "temperature", nullable = false)
    private double temperature;

    @Column(name = "max_tokens", nullable = false)
    private int maxTokens;

    @Column(name = "top_p", nullable = false)
    private double topP;

    @Column(name = "frequency_penalty", nullable = false)
    private double frequencyPenalty;

    @Column(name = "presence_penalty", nullable = false)
    private double presencePenalty;

    @Column(name = "timeout_seconds", nullable = false)
    private int timeoutSeconds;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "active", nullable = false)
    private boolean active;
}
