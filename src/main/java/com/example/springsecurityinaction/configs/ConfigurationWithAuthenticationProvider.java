//package com.example.springsecurityinaction.configs;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//public class ConfigurationWithAuthenticationProvider {
//
//    private final CustomAuthenticationProvider customAuthenticationProvider;
//
//    public ConfigurationWithAuthenticationProvider(CustomAuthenticationProvider customAuthenticationProvider) {
//        this.customAuthenticationProvider = customAuthenticationProvider;
//    }
//
//    // if we want to override the authentication provider, we must register its bean in the filterChain bean
//    // if UDS and PE are registered, spring automatically creates the authenticationProvider bean
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http.httpBasic();
//        http.authorizeHttpRequests().anyRequest().authenticated();
//        http.getSharedObject(AuthenticationManagerBuilder.class)
//                .authenticationProvider(customAuthenticationProvider);
//        return http.build();
//    }
//}
