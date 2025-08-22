package com.hackers.blogbackend.repository;

import java.util.Optional;


import com.hackers.blogbackend.entity.Category;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface CategoryRepository extends AbstractEntityInterface<Category, String> {

    /**
     * Finds a category by its name.
     *
     * @param name the name of the category
     * @return an Optional containing the Category if found, or empty if not found
     */
    Optional<Category> findByName(String name);

    /**
     * Checks if a category exists by its name.
     *
     * @param name the name of the category
     * @return true if a category with the given name exists, false otherwise
     */
    boolean existsByName(String name);

}
