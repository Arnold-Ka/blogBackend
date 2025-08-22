package com.hackers.blogbackend.repository;

import java.util.List;
import java.util.Optional;


import com.hackers.blogbackend.entity.Post;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface PostRepository extends AbstractEntityInterface<Post, String> {

    /**
     * Finds a post by its title.
     *
     * @param title the title of the post
     * @return an Optional containing the Post if found, or empty if not found
     */
    Optional<Post> findByTitle(String title);

    /**
     * Checks if a post exists by its title.
     *
     * @param title the title of the post
     * @return true if a post with the given title exists, false otherwise
     */
    boolean existsByTitle(String title);
    List <String> findSlugsLike(String baseSlug);

}
