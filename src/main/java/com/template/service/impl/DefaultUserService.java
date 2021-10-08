package com.template.service.impl;

import com.template.exc.NotFoundException;
import com.template.page.UserProfilePage;
import com.template.repository.domain.UserRepository;
import com.template.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
public class DefaultUserService implements UserService {

    private final UserRepository repository;

    @Override
    @Transactional(readOnly = true)
    public UserProfilePage userPageById(final Integer id) throws NotFoundException {
        return this.repository
            .getOneById(id)
            .map(UserProfilePage.FromEntity::new)
            .orElseThrow(
                () ->
                    new NotFoundException(
                        String.format(
                            "User with id %d doesn't exist",
                            id
                        )
                    )
            );
    }

    @Override
    public void registerUser() {
        throw new UnsupportedOperationException("#registerUser()");
    }
}
