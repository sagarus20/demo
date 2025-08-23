package com.gm.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
public class SecurityConfig  {
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails admin = User.withUsername("admin")
                .password("{noop}123")
                .roles("ADMIN", "USER")
                .build();

        UserDetails user = User.withUsername("user")
                .password("{noop}123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(admin, user);
    }
    @Bean
    public WebSecurityCustomizer webSecurityCustomizer() {
        return (web) -> web.ignoring();

    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
        .authorizeHttpRequests(auth -> auth
            .requestMatchers("/editar/**", "/agregar/**", "/eliminar/**")
                .hasRole("ADMIN")
            .requestMatchers("/")
                .hasAnyRole("ADMIN", "USER")
            .anyRequest().authenticated()
        )
        .formLogin(form -> form
            .loginPage("/login")
            .permitAll()
        )
        .logout(logout -> logout
            .permitAll()
        )
        .exceptionHandling(ex -> ex
            .accessDeniedPage("/errores/403"))
        ;

    return http.build();
}
}
