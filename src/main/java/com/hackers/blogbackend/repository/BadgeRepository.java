package com.hackers.blogbackend.repository;

import java.util.Optional;


import com.hackers.blogbackend.entity.Badge;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface BadgeRepository extends AbstractEntityInterface<Badge, String> {

    /**
     * Finds a badge by its name.
     *
     * @param name the name of the badge
     * @return an Optional containing the Badge if found, or empty if not found
     */
    Optional<Badge> findByName(String name);

    /**
     * Checks if a badge exists by its name.
     *
     * @param name the name of the badge
     * @return true if a badge with the given name exists, false otherwise
     */
    boolean existsByName(String name);

}
