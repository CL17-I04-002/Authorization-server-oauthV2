package com.cursos.api.authorization_server.config.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth2.server.authorization.token.JwtEncodingContext;
import org.springframework.security.oauth2.server.authorization.token.OAuth2TokenCustomizer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomOAuth2TokenCustomaizer implements OAuth2TokenCustomizer<JwtEncodingContext> {
    /**
     * It personalizes JWT only when will be access_token, we could add authorities into claims
     * @param context the context containing the OAuth 2.0 Token attributes
     */
    @Override
    public void customize(JwtEncodingContext context) {
        Authentication authentication = context.getPrincipal();
        String tokenType = context.getTokenType().getValue();

        if(tokenType.equals("access_token")){
            List<String> authorities = authentication.getAuthorities().stream()
                    .map(GrantedAuthority::getAuthority)
                    .collect(Collectors.toList());
            context.getClaims().claim("permissions", authorities);
        }
    }
}
