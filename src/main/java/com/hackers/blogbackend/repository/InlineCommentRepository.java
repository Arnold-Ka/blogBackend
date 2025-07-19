package com.hackers.blogbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackers.blogbackend.entity.InlineComment;

public interface InlineCommentRepository extends JpaRepository<InlineComment, Long> {

    /**
     * Finds an inline comment by its content.
     *
     * @param content the content of the inline comment
     * @return an Optional containing the InlineComment if found, or empty if not found
     */
    Optional<InlineComment> findByContent(String content);

    /**
     * Checks if an inline comment exists by its content.
     *
     * @param content the content of the inline comment
     * @return true if an inline comment with the given content exists, false otherwise
     */
    boolean existsByContent(String content);

}
