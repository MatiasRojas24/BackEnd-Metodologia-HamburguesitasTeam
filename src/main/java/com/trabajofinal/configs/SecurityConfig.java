package com.trabajofinal.configs;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor

public class SecurityConfig {

    private final JwtAutheticationFilter jwtAutheticationFilter;
    private final AuthenticationProvider authProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        return http
                .csrf(csrf ->
                        csrf
                                .disable())
                            .authorizeHttpRequests(authRequest ->
                                authRequest
                                    .requestMatchers("/auth/**").permitAll()
                                        .requestMatchers("/usuarios/**").authenticated()
                                        .requestMatchers("/direcciones/**").authenticated()
                                        .requestMatchers("/ordenesDeCompra/**").authenticated()
                                        .requestMatchers("/ordenComprasDetalles/**").authenticated()
                                    .anyRequest().permitAll()

                                     )
                                .sessionManagement(sessionManager ->
                                    sessionManager
                                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                                .authenticationProvider(authProvider)
                                .addFilterBefore(jwtAutheticationFilter, UsernamePasswordAuthenticationFilter.class)
                                .build();
    }

}
