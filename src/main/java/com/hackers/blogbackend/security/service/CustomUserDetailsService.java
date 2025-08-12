package com.hackers.blogbackend.security.service;

import java.util.Collection;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackers.blogbackend.entity.User;
import com.hackers.blogbackend.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> 
                    new UsernameNotFoundException("Utilisateur non trouvé : " + username)
                );

        return new org.springframework.security.core.userdetails.User(
                user.getUsername(),
                user.getPassword(),
                getAuthorities(user)
        );
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        return user.getRoles().stream()
                .flatMap(role -> {
                    
                    Stream<GrantedAuthority> roleAuth =
                            Stream.of(new SimpleGrantedAuthority(role.getName()));
                    
                    Stream<GrantedAuthority> permAuth =
                            role.getPermissions().stream()
                                .map(perm -> new SimpleGrantedAuthority(perm.getName()));
                    return Stream.concat(roleAuth, permAuth);
                })
                .collect(Collectors.toSet());
    }
}
