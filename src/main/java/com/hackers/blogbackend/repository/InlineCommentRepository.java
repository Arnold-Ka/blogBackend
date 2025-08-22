package com.hackers.blogbackend.repository;

import java.util.Optional;


import com.hackers.blogbackend.entity.InlineComment;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface InlineCommentRepository extends AbstractEntityInterface<InlineComment, String> {

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
