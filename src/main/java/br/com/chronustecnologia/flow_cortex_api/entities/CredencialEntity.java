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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "clientid", nullable = false, unique = true, length = 255)
    private String clientId;

    @Column(name = "clientsecret", nullable = false, length = 255)
    private String clientSecret;

    @Column(name = "granttypes", nullable = false, length = 255)
    private String grantTypes;

    @Column(name = "scopes", nullable = false, length = 255)
    private String scopes;

    @Column(name = "active", nullable = false)
    private boolean active;
}
