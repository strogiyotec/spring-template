package com.template.repository.springdata;

import com.template.model.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserSpringRepository extends CrudRepository<User, Integer> {
}
