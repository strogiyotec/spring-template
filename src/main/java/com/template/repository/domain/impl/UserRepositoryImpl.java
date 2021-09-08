package com.template.repository.domain.impl;

import com.template.model.entity.User;
import com.template.repository.domain.UserRepository;
import com.template.repository.springdata.UserSpringRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserSpringRepository repository;

    @Override
    public User getOneById(final Integer id) {
        return this.repository.findById(id).orElseThrow(IllegalStateException::new);
    }
}
