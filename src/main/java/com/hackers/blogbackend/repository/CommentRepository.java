package com.hackers.blogbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackers.blogbackend.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, String> {

    /**
     * Finds a comment by its content.
     *
     * @param content the content of the comment
     * @return an Optional containing the Comment if found, or empty if not found
     */
    Optional<Comment> findByContent(String content);

    /**
     * Checks if a comment exists by its content.
     *
     * @param content the content of the comment
     * @return true if a comment with the given content exists, false otherwise
     */
    boolean existsByContent(String content);

}
