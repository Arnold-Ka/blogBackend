package com.hackers.blogbackend.security.controller;

public record RegisterDto(String username, String email, String password, String confirmPassword,String createdBy) {
} 