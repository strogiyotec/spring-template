package com.template.repository.domain;

import com.template.model.entity.UserEntity;
import java.util.Optional;

public interface UserRepository {

    Optional<UserEntity> getOneById(Integer id);

    UserEntity save(UserEntity user);


}
