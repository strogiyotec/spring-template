package com.template.page;

import com.template.model.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.experimental.Delegate;

/**
 * User Profile page.
 */
public interface UserProfilePage {

    String getName();

    String getSurname();

    String getEmail();

    /**
     * Default impl that delegates data access to entity
     */
    @AllArgsConstructor
    final class FromEntity implements UserProfilePage {

        @Delegate
        private final UserEntity entity;

    }
}
