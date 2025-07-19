package com.hackers.blogbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackers.blogbackend.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

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

}
