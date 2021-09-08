package com.template.repository.domain;

import com.template.model.entity.User;

public interface UserRepository {

    User getOneById(Integer id);
}
