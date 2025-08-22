package com.hackers.blogbackend.repository;

import java.util.Optional;


import com.hackers.blogbackend.entity.AiRecommendation;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface AiRecommendationRepository extends AbstractEntityInterface<AiRecommendation, String> {

    /**
     * Finds an AI recommendation by its title.
     *
     * @param title the title of the AI recommendation
     * @return an Optional containing the AiRecommendation if found, or empty if not found
     */
    Optional<AiRecommendation> findByTitle(String title);

    /**
     * Checks if an AI recommendation exists by its title.
     *
     * @param title the title of the AI recommendation
     * @return true if an AI recommendation with the given title exists, false otherwise
     */
    boolean existsByTitle(String title);

}
