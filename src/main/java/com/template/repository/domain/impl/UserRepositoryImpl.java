package com.template.repository.domain.impl;

import com.template.model.entity.UserEntity;
import com.template.repository.domain.UserRepository;
import com.template.repository.springdata.UserSpringRepository;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserSpringRepository repository;

    @Override
    public Optional<UserEntity> getOneById(final Integer id) {
        return this.repository.findById(id);
    }
}
