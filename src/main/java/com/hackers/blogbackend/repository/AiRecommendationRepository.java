package com.hackers.blogbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackers.blogbackend.entity.AiRecommendation;

public interface AiRecommendationRepository extends JpaRepository<AiRecommendation, Long> {

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
