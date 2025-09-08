package com.hackers.blogbackend.security.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hackers.blogbackend.entity.User;
import com.hackers.blogbackend.mapper.BlMapper;
import com.hackers.blogbackend.repository.UserRepository;
import com.hackers.blogbackend.security.jwt.JwtUtils;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
@Slf4j
public class AuthController {
    AuthenticationManager authenticationManager;
    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;
    BlMapper mapper;
    JwtUtils jwt;

    @PostMapping("/login")
    Map<String, String> login(@RequestBody AuthenticationDto authenticationDto){
        Authentication authentication = authenticationManager.authenticate(
                                                                        new UsernamePasswordAuthenticationToken(authenticationDto.username(),
                                                                                                            authenticationDto.password())
                                                                                                            );
        log.info("resultat {}" , authentication.isAuthenticated());
        if (authentication.isAuthenticated()) {
            return jwt.generateToken(authenticationDto.username());
        }                                                                                  
        return null;
    }

    @PostMapping("/register")
    public Map<HttpStatus, String> register(@RequestBody RegisterDto registerDto){
        if (!registerDto.password().equals(registerDto.confirmPassword())) {
            throw new IllegalArgumentException("les mot de passe ne correspondent pas"+ " " + registerDto.password() + "     " + registerDto.confirmPassword());
        }
        User user = mapper.registerToUser(registerDto);

        user.setPassword(bCryptPasswordEncoder.encode(registerDto.password()));
        userRepository.save(user);
        return Map.of(HttpStatus.CREATED, "l'utilisateur a éte ajouter");
    }

}
