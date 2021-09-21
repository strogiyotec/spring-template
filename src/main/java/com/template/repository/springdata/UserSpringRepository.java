package com.template.repository.springdata;

import com.template.model.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserSpringRepository extends CrudRepository<UserEntity, Integer> {
}
