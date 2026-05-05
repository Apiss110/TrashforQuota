package com.trashforquota.ProjectPBO.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Keamanan password wajib di-hash
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/login", "/css/**", "/js/**").permitAll() // Halaman login & static files bebas akses
                .requestMatchers("/admin/**").hasRole("ADMIN") // Hanya untuk Admin
                .requestMatchers("/user/**").hasRole("USER")   // Hanya untuk User biasa
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login") // Custom halaman login Thymeleaf kita
                .defaultSuccessUrl("/dashboard", true) // Redirect setelah sukses login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
            );

        return http.build();
    }
}