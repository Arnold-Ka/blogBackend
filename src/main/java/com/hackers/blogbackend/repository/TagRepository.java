package com.hackers.blogbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackers.blogbackend.entity.Tag;

public interface TagRepository extends JpaRepository<Tag, String> {

    /**
     * Finds a tag by its name.
     *
     * @param name the name of the tag
     * @return an Optional containing the Tag if found, or empty if not found
     */
    Optional<Tag> findByName(String name);

    /**
     * Checks if a tag exists by its name.
     *
     * @param name the name of the tag
     * @return true if a tag with the given name exists, false otherwise
     */
    boolean existsByName(String name);

}
