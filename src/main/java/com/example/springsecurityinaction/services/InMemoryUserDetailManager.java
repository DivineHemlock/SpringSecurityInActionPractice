package com.example.springsecurityinaction.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.provisioning.UserDetailsManager;

import java.util.List;

public class InMemoryUserDetailManager implements UserDetailsManager {

    private final List<UserDetails> users;

    public InMemoryUserDetailManager(List<UserDetails> users) {
        this.users = users;
    }


    @Override
    public void createUser(UserDetails user) {
        users.add(user);
    }

    @Override
    public void updateUser(UserDetails user) {

    }

    @Override
    public void deleteUser(String username) {
        users.remove(users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(
                        () ->  new UsernameNotFoundException("no such user")
                ));
    }

    @Override
    public void changePassword(String oldPassword, String newPassword) {

    }

    @Override
    public boolean userExists(String username) {
        return false;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return users.stream()
                .filter(u -> u.getUsername().equals(username))
                .findFirst()
                .orElseThrow(
                        () -> new UsernameNotFoundException("not found")
                );
    }
}
