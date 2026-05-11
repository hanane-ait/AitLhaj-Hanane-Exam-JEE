package com.youssfi.controle.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(
            PasswordEncoder passwordEncoder){

        UserDetails admin = User
                .withUsername("admin")
                .password(passwordEncoder.encode("1234"))
                .roles("ADMIN")
                .build();

        UserDetails employe = User
                .withUsername("employe")
                .password(passwordEncoder.encode("1234"))
                .roles("EMPLOYE")
                .build();

        UserDetails client = User
                .withUsername("client")
                .password(passwordEncoder.encode("1234"))
                .roles("CLIENT")
                .build();

        return new InMemoryUserDetailsManager(
                admin,
                employe,
                client
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(
            HttpSecurity http) throws Exception {

        http
                .csrf(csrf -> csrf.disable())

                .authorizeHttpRequests(auth -> auth

                        .requestMatchers("/h2-console/**")
                        .permitAll()

                        .requestMatchers("/api/agencies/**")
                        .hasAnyRole("ADMIN","EMPLOYE")

                        .requestMatchers("/api/locations/**")
                        .hasAnyRole("ADMIN","EMPLOYE")

                        .requestMatchers("/api/vehicles/**")
                        .hasAnyRole(
                                "ADMIN",
                                "EMPLOYE",
                                "CLIENT"
                        )

                        .anyRequest()
                        .authenticated()
                )

                .httpBasic(Customizer.withDefaults());

        http.headers(headers ->
                headers.frameOptions(frame ->
                        frame.disable()));

        return http.build();
    }
}