package com.hackers.blogbackend.repository;

import java.util.List;
import java.util.Optional;


import com.hackers.blogbackend.entity.Comment;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

import org.springframework.lang.NonNull;

public interface CommentRepository extends AbstractEntityInterface<Comment, String> {

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

    List<Comment> findByPostId(String postId);
    boolean existsById(@NonNull String id);

}
