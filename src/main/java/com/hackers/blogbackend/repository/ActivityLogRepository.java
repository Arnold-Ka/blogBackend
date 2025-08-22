package com.hackers.blogbackend.repository;

import java.util.Optional;


import com.hackers.blogbackend.entity.ActivityLog;
import com.hackers.blogbackend.utils.AbstractEntityInterface;

public interface ActivityLogRepository extends AbstractEntityInterface<ActivityLog, String> {

    /**
     * Finds an activity log by its action.
     *
     * @param action the action of the activity log
     * @return an Optional containing the ActivityLog if found, or empty if not found
     */
    Optional<ActivityLog> findByAction(String action);

    /**
     * Checks if an activity log exists by its action.
     *
     * @param action the action of the activity log
     * @return true if an activity log with the given action exists, false otherwise
     */
    boolean existsByAction(String action);

}
