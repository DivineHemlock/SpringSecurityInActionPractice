//package com.example.springsecurityinaction.services;
//
//import com.example.springsecurityinaction.security.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//
//import java.util.List;
//
//public class InMemoryUserDetailsService implements UserDetailsService {
//
//    private final List<User> users;
//
//    public InMemoryUserDetailsService(List<User> users) {
//        this.users = users;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        return users.stream()
//                .filter(u -> u.getUsername().equals(username))
//                .findFirst()
//                .orElseThrow(
//                        () -> new UsernameNotFoundException("User Not Found")
//                );
//    }
//}
