package com.hackers.blogbackend.repository;
import java.util.Optional;
import com.hackers.blogbackend.entity.User;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface UserRepository extends AbstractEntityInterface<User, String> {

    /**
     * Finds a user by their email.
     *
     * @param email the email of the user
     * @return an Optional containing the User if found, or empty if not found
     */
    Optional<User> findByEmail(String email);

    /**
     * Checks if a user exists by their email.
     *
     * @param email the email of the user
     * @return true if a user with the given email exists, false otherwise
     */
    boolean existsByEmail(String email);

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user
     * @return an Optional containing the User if found, or empty if not found
     */
    Optional<User> findByUsername(String username);

}
