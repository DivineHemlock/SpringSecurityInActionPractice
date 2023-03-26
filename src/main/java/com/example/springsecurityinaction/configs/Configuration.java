package com.example.springsecurityinaction.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public UserDetailsService userDetailsService() {
        var userDetailsService =
                new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("mohsen")
                .password("123")
                .authorities("read")
                .build();
        userDetailsService.createUser(user);
        return userDetailsService;
    }

    @Bean
    public UserDetailsService userDetailsService_2() {
        var userDetailsService =
                new InMemoryUserDetailsManager();
        UserDetails user = User.withUsername("mohsen_a")
                .password("123")
                .authorities("read")
                .build();
        userDetailsService.createUser(user);
        return userDetailsService;
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }


    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeHttpRequests().anyRequest().authenticated();
        http.getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(userDetailsService())
                .and()
                .userDetailsService(userDetailsService_2())
                .passwordEncoder(passwordEncoder());
        return http.build();
    }

}
