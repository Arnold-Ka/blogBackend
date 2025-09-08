package com.hackers.blogbackend.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.hackers.blogbackend.dto.UserDto;
import com.hackers.blogbackend.service.interfaces.UserServiceInterface;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtUtils {

    @Value("${jwt.secret-key}")
    private  String JWT_SECRET;
    @Value("${jwt.expiration-time}")
    private long expirationMs;
    @Autowired
    UserServiceInterface userService;

    public Map<String, String> generateToken(String username) throws UsernameNotFoundException {
        UserDto userDto = userService.getUserbyUsername(username);

        Map<String, Object> claims = Map.of(
            "identifiant",userDto.getId(),
            "email",userDto.getEmail(),
            "roles",userDto.getRoles()
        );
        String token = Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expirationMs))
                .setClaims(claims)
                .signWith(generateKey(), SignatureAlgorithm.HS256)
                .compact();
        return Map.of("access-token", token);
    }

    private Key generateKey() {
        byte[] decode = Decoders.BASE64.decode(JWT_SECRET);
        return Keys.hmacShaKeyFor(decode);
    }

    // public String getUsernameFromToken(String token) {
    //     return Jwts.parserBuilder()
    //             .setSigningKey(key)
    //             .build()
    //             .parseClaimsJws(token)
    //             .getBody()
    //             .getSubject();
    // }

    // public boolean validateToken(String token) {
    //     try {
    //         Jwts.parserBuilder()
    //             .setSigningKey(key)
    //             .build()
    //             .parseClaimsJws(token);
    //         return true;
    //     } catch (JwtException | IllegalArgumentException e) {
            
    //         return false;
    //     }
    // }
}

