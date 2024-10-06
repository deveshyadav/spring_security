package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Replacing the configure method with SecurityFilterChain bean
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .antMatchers("/api/public").permitAll()      // Public endpoint
                        .antMatchers("/api/admin").hasRole("ADMIN")  // Admin-only endpoint
                        .anyRequest().authenticated()                // All other endpoints require authentication
                )
                //.oauth2Login() In case of oauth2 login
                //.and()
                .httpBasic();  // Using basic authentication

        return http.build();
    }

    // Replacing inMemoryAuthentication() with a UserDetailsService bean
    @Bean
    public UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(
                User.withUsername("user")
                        .password(passwordEncoder().encode("password"))
                        .roles("USER")
                        .build()
        );
        userDetailsManager.createUser(
                User.withUsername("admin")
                        .password(passwordEncoder().encode("admin"))
                        .roles("ADMIN")
                        .build()
        );
        return userDetailsManager;
    }

    // Bean for password encoding
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
