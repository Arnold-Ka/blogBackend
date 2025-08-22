package com.hackers.blogbackend.repository;

import java.util.Optional;


import com.hackers.blogbackend.entity.Notification;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface NotificationRepository extends AbstractEntityInterface<Notification, String> {

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
