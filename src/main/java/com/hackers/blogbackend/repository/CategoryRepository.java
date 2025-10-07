package com.hackers.blogbackend.repository;



import com.hackers.blogbackend.entity.Category;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface CategoryRepository extends AbstractEntityInterface<Category, String> {

    /**
     * Finds a category by its name.
     *
     * @param name the name of the category
     * @return a boolean indicating if the Category was found
     */
    boolean findByName(String name);

    /**
     * Finds a category by its slug.
     *
     * @param slug the slug of the category
     * @return a boolean indicating if the Category was found
     */
    boolean findBySlug(String slug);


    /**
     * Checks if a category exists by its name.
     *
     * @param name the name of the category
     * @return true if a category with the given name exists, false otherwise
     */
    boolean existsByName(String name);

}
