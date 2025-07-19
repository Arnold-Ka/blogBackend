package com.hackers.blogbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackers.blogbackend.entity.Badge;

public interface BadgeRepository extends JpaRepository<Badge, Long> {

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
