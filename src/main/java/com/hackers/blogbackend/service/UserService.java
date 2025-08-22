package com.hackers.blogbackend.service;

import com.hackers.blogbackend.dto.UserDto;
import com.hackers.blogbackend.entity.User;
import com.hackers.blogbackend.mapper.BlMapper;
import com.hackers.blogbackend.repository.UserRepository;
import com.hackers.blogbackend.service.interfaces.UserServiceInterface;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService implements UserServiceInterface {
    private final UserRepository userRepository;
    private final BlMapper mapper = Mappers.getMapper(BlMapper.class);

    /**
     * Recupretaion d'un utilisateur a partir de son identifiant.
     * @param id l'indentifiant de l'utilisateur
     * @return l'utilisateur
     */
    @Transactional
    @Override
    public Optional<UserDto> getUserbyId(String id) {
        return userRepository.findById(id).map(mapper::maps);
    }

    /**
     * Recupretaion d'un utilisateur a partir de son email.
     * @param email l'email de l'utilisateur
     * @return l'utilisateur
     */
    @Override
    public Optional<UserDto> getUserbyEmail(String email) {
        return userRepository.findByEmail(email).map(mapper::maps);
    }

    /**
     * Recupretaion d'un utilisateur a partir de son pseudo.
     * @param username le pseudo de l'utilisateur
     * @return l'utilisateur
     */
    @Override
    public Optional<UserDto> getUserbyUsername(String username) {
        return userRepository.findByUsername(username).map(mapper::maps);
    }

    /**
     * Recupretaion de tous les utilisateur.
     * @return la liste des utilisateur actif
     */
    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream().map(mapper::maps)
                .collect(
                    Collectors.toList()
                );
    }

    /**
     * Ajout d'un nouveau utilisateur
     * @param userDto les donnees de l'utilisateur
     * @return l'utilisateur
     */
    @Override
    public UserDto addUser(UserDto userDto) {
        return mapper.maps(userRepository.save(mapper.maps(userDto)));
    }

    /**
     * Modification des donnees d'un utilisateur.
     * @param id l'identifiant de l'utilisateur
     * @param userDto les nouvelles donnees de l'utilisateur
     * @return
     */
    @Override
    public UserDto updateUser(String id, UserDto userDto) {
        User user = new User();
        user = mapper.maps(userDto);
        user.setId(id);
        userRepository.save(user);
        return mapper.maps(user);
    }

    /**
     * Supprime un utilisateur.
     * @param id l'identifiant de l'utilisateur a supprimer
     */
    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }
}
