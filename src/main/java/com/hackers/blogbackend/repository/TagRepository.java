package com.hackers.blogbackend.repository;

import java.util.Optional;


import com.hackers.blogbackend.entity.Tag;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface TagRepository extends AbstractEntityInterface<Tag, String> {

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
