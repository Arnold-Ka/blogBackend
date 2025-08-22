package com.hackers.blogbackend.repository;

import java.util.Optional;


import com.hackers.blogbackend.entity.Reaction;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface ReactionRepository extends AbstractEntityInterface<Reaction, String> {

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
