package com.template.service.impl;

import com.template.controller.input.RegisterUserRequest;
import com.template.controller.output.RegisterUserResponse;
import com.template.exc.NotFoundException;
import com.template.model.entity.UserEntity;
import com.template.page.UserProfilePage;
import com.template.repository.domain.UserRepository;
import com.template.service.UserService;
import java.util.Date;
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

    //TOOD: add map struct
    @Override
    public RegisterUserResponse registerUser(final RegisterUserRequest request) {
        final UserEntity saved = this.repository.save(
            UserEntity.builder()
                .username(request.getUsername())
                .createdAt(new Date())
                .email(request.getEmail())
                .password(request.getPassword())
                .name(request.getName())
                .surname(request.getSurname())
                .build()
        );
        return new RegisterUserResponse(
            saved.getId()
        );
    }
}
