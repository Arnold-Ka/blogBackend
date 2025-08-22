package com.hackers.blogbackend.repository;

import java.util.Optional;


import com.hackers.blogbackend.entity.QuizBlock;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface QuizBlockRepository extends AbstractEntityInterface<QuizBlock, String> {

    /**
     * Finds a quiz block by its title.
     *
     * @param title the title of the quiz block
     * @return an Optional containing the QuizBlock if found, or empty if not found
     */
    Optional<QuizBlock> findByTitle(String title);

    /**
     * Checks if a quiz block exists by its title.
     *
     * @param title the title of the quiz block
     * @return true if a quiz block with the given title exists, false otherwise
     */
    boolean existsByTitle(String title);

}
