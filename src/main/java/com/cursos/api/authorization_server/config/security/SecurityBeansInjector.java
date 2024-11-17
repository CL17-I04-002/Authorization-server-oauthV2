package com.cursos.api.authorization_server.config.security;


import com.cursos.api.authorization_server.exception.ObjectNotFoundException;
import com.cursos.api.authorization_server.persistence.repository.security.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * It's only necessary add those configurations, nothing related to JWT's configuration because OAuth2 configured it
 */
@Configuration
public class SecurityBeansInjector {
    @Autowired
    private UserRepository userRepository;

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    public UserDetailsService userDetailsService(){
        return (username -> {
            return userRepository.findByUsername(username)
                    .orElseThrow(() -> new ObjectNotFoundException("user not found with username " + username));
        });
    }
}
