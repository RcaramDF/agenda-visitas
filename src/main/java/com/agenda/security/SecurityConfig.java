package com.agenda.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public InMemoryUserDetailsManager userDetailsService() {
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("admin123")
                .roles("ADMIN")
                .build();

        UserDetails consultor = User.withDefaultPasswordEncoder()
                .username("joao")
                .password("1234")
                .roles("CONSULTOR")
                .build();

        return new InMemoryUserDetailsManager(admin, consultor);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/visitas/**", "/api/**", "/dashboard").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin().defaultSuccessUrl("/visitas/nova", true)
            .and()
            .logout().logoutSuccessUrl("/login?logout")
            .and()
            .csrf().disable();

        return http.build();
    }
}
