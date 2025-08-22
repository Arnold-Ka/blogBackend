package com.hackers.blogbackend.controller;

import com.hackers.blogbackend.dto.UserDto;
import com.hackers.blogbackend.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserServiceInterface userService;

    /**
     * Recuperation de tous les utilisateur.
     * @return la liste des utilisateur
     */
    @GetMapping(value = "/users")
    public List<UserDto> getAllUsers() {
        return userService.getAllUsers();
    }

    /**
     * Recuperation d'un utilisateur a partir de son id.
     * @param userId l'identifiant de l'utilissateur
     * @return l'utilisateur sous format json
     */
    @GetMapping(value = "/users/{userId}")
    public Optional<UserDto> getUserById(@PathVariable(name = "userId") final String userId) {
        return userService.getUserbyId(userId);
    }

    /**
     * Recuperation d'un utilisateur a partir de son email.
     * @param email l'email de l'utilisateur
     * @return l'utilisateur sous format json
     */
    @GetMapping(value = "/users/el/{email}")
    public Optional<UserDto> getUserByEmail(@PathVariable(name = "email") final String email) {
        return userService.getUserbyEmail(email);
    }

    /**
     * Recuperation d'un utilisateur a partir de son pseudo.
     * @param username le pseudo de l'utilisateur
     * @return l'utilisateur sous format json
     */
    @GetMapping(value = "/users/um/{username}")
    public Optional<UserDto> getUserByUsername(@PathVariable(name = "username") final String username) {
        return userService.getUserbyUsername(username);
    }

    /**
     * Ajout d'un nouveau utilisateur.
     * @param userDto les informations de l'uilisateurs
     * @return le nouveau utilisateur creer
     */
    @PostMapping(value = "/users")
    public UserDto createUser(@RequestBody final UserDto userDto) {
        return userService.addUser(userDto);
    }

    /**
     * Mise a jour des informations d'un utilisateur.
     * @param userId l'identifiant de l'utilisateur
     * @param userDto les nouvelles données de l'utilisateur
     * @return l'utilisateur mis a jour
     */
    @PutMapping(value = "/users/{userId}")
    public UserDto updateUser(@PathVariable(name = "userId") final String userId, @RequestBody final UserDto userDto) {
        return userService.updateUser(userId, userDto);
    }

    /**
     * suppression d'un utilisateur a partir de son identifiant.
     * @param userId l'identifiant de l'utilisateur
     */
    @DeleteMapping(value = "/users/{id}")
    public void deleteUser(@PathVariable(name = "id") final String userId) {
        userService.deleteUser(userId);
    }
}
