package com.hackers.blogbackend.security.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackers.blogbackend.repository.UserRepository;
import com.hackers.blogbackend.security.model.CustomUserDetails;

import jakarta.transaction.Transactional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUserDetails customUserDetails = new CustomUserDetails(userRepository.findByUsername(username)
                .orElseThrow(() -> 
                    new UsernameNotFoundException("Utilisateur non trouvé : " + username)
                ));

        return customUserDetails;
    }

    // private Collection<? extends GrantedAuthority> getAuthorities(User user) {
    //     return user.getRoles().stream()
    //             .flatMap(role -> {
                    
    //                 Stream<GrantedAuthority> roleAuth =
    //                         Stream.of(new SimpleGrantedAuthority(role.getName()));
                    
    //                 Stream<GrantedAuthority> permAuth =
    //                         role.getPermissions().stream()
    //                             .map(perm -> new SimpleGrantedAuthority(perm.getName()));
    //                 return Stream.concat(roleAuth, permAuth);
    //             })
    //             .collect(Collectors.toSet());
    // }
}
