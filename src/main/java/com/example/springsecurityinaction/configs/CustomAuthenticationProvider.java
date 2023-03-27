package com.example.springsecurityinaction.configs;

import jakarta.websocket.server.PathParam;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.sql.Array;
import java.util.Arrays;

// if we want to override the authentication provider, we must register its bean in the filterChain bean
@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();
        // the following if-else statement is for show purpose only, the authentication provider usually
        // calls userDetailsService and the passwordEncoder to authenticate the user
        if (username.equals("mohsen_b") && password.equals("123")) {
            /*
             @param third param is the list of authorities, in this example, the list is empty
             @return a UsernamePassAuthenticationToken which will be stored in spring context
             */
            return new UsernamePasswordAuthenticationToken(username, password, Arrays.asList());
        } else {
            throw new AuthenticationCredentialsNotFoundException("no match found !");
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class
                .isAssignableFrom(authentication);
    }
}
