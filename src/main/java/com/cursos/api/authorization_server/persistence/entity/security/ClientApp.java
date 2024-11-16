package com.cursos.api.authorization_server.persistence.entity.security;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/*
Those are app's clients
 */
@Entity
@Data
@NoArgsConstructor
public class ClientApp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String clientId;
    private String clientSecret;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> clientAuthenticationMethods;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> authorizationGrantTypes;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> redirectUris;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> postLogoutRedirectUris;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> scopes;
    private int durationInMinutes;
    private boolean requiredProofKey;
}