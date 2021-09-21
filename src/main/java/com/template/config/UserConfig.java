package com.template.config;

import com.template.repository.domain.UserRepository;
import com.template.service.UserService;
import com.template.service.impl.DefaultUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {

    @Autowired
    private UserRepository userRepository;

    @Bean
    public UserService userService() {
        return new DefaultUserService(this.userRepository);
    }
}
