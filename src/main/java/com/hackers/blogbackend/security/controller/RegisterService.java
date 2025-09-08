package com.hackers.blogbackend.security.controller;

import org.springframework.stereotype.Service;

import com.hackers.blogbackend.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RegisterService {
    UserRepository userRepository;
    

}
