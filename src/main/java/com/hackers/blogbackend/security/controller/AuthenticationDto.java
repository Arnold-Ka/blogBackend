package com.hackers.blogbackend.security.controller;

public record AuthenticationDto(
    String username,
    String password
) {

}

