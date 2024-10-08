package com.fileupload.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf().disable() // Disable CSRF protection for simplicity
            .authorizeRequests()
            .requestMatchers("/api/files/**").permitAll() // Allow unauthenticated access to these endpoints
            .anyRequest().authenticated()
            .and()
            .formLogin().permitAll();

        return http.build();
    }
}
