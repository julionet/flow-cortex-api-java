package br.com.chronustecnologia.flow_cortex_api.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "credencial")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CredencialEntity {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false, unique = true, length = 255)
    private String clientId;

    @Column(nullable = false, length = 255)
    private String clientSecret;

    @Column(nullable = false, length = 255)
    private String grantTypes;

    @Column(nullable = false, length = 255)
    private String scopes;

    @Column(nullable = false)
    private boolean active;
}
