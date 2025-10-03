package com.hackers.blogbackend.service.interfaces;

import com.hackers.blogbackend.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserServiceInterface {
    /**
     * Récupere un utilisateur via son identifiant.
     * @param id l'indentifiant de l'utilisateur
     * @return l'utilisateur
     */
    public Optional<UserDto> getUserbyId(String id);
    /**
     * Récupere un utilisateur via son email.
     * @param email l'email de l'utilisateur
     * @return l'utilisateur
     */
    public Optional<UserDto> getUserbyEmail(String email);
    /**
     * Récupere un utilisateur via son pseudo.
     * @param username le pseudo de l'utilisateur
     * @return l'utilisateur
     */
    public UserDto getUserbyUsername(String username);

    /**
     * Recuperer la liste de tous les utiisateurs.
     * @return la liste des utilisateur
     */
    public List<UserDto> getAllUsers();

    /**
     * Met a jour un utilisateur.
     * @param id l'identifiant de l'utilisateur
     * @param userDto les nouvelles donnees de l'utilisateur
     * @return l'utilisateur avec les donnees modifier
     */
    public UserDto updateUser(String id,UserDto userDto);

    /**
     * Spprime un utilisateur.
     * @param id l'identifiant de l'utilisateur a supprimer
     */
    public void deleteUser(String id);

    

}
