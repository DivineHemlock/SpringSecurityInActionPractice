package com.example.springsecurityinaction.config;

import com.example.springsecurityinaction.security.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Configuration
public class Config {

    @Bean
    public UserDetailsService userDetailsService() {
        User user = new User("john", "{noop}12345", "READ");
        List<UserDetails> users = List.of(user);
        return new InMemoryUserDetailsManager(users);
    }

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return NoOpPasswordEncoder.getInstance();
//    }

    // using DelegatingPasswordEncoder for creating the PasswordEncoder Bean
    // reference : page 125, listing 4.4
    @Bean
    public PasswordEncoder passwordEncoder() {
        Map<String, PasswordEncoder> encoderMap = new HashMap<>();
        encoderMap.put("noop", NoOpPasswordEncoder.getInstance());
        encoderMap.put("bcrypt", new BCryptPasswordEncoder());
        // if the password has no prefix, e.g: it has no {noop} or {bcrypt}, DPE uses the default case which is
        // the first argument in its constructor
        return new DelegatingPasswordEncoder("noop", encoderMap);
    }
}
