package com.hackers.blogbackend.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hackers.blogbackend.entity.Notification;

public interface NotificationRepository extends JpaRepository<Notification, String> {

    /**
     * Finds a notification by its title.
     *
     * @param title the title of the notification
     * @return an Optional containing the Notification if found, or empty if not found
     */
    Optional<Notification> findByTitle(String title);

    /**
     * Checks if a notification exists by its title.
     *
     * @param title the title of the notification
     * @return true if a notification with the given title exists, false otherwise
     */
    boolean existsByTitle(String title);

}
