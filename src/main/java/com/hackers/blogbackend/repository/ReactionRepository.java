package com.hackers.blogbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackers.blogbackend.entity.Reaction;

public interface ReactionRepository extends JpaRepository<Reaction, String> {

    /**
     * Finds a reaction by its type.
     *
     * @param type the type of the reaction
     * @return an Optional containing the Reaction if found, or empty if not found
     */
    Optional<Reaction> findByType(String type);

    /**
     * Checks if a reaction exists by its type.
     *
     * @param type the type of the reaction
     * @return true if a reaction with the given type exists, false otherwise
     */
    boolean existsByType(String type);

}
