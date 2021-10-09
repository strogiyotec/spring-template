package com.template.controller.user;

import com.template.controller.output.RegisterUserResponse;
import com.template.service.UserService;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.mockito.junit.MockitoRule;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

/**
 * Test config to test {@link UserController}.
 */
@TestConfiguration
public class UserControllerConfig {

    @Bean
    public UserService userService() {
        final UserService mock = Mockito.mock(UserService.class);
        Mockito.when(mock.registerUser(ArgumentMatchers.any())).thenReturn(new RegisterUserResponse(1));
        return mock;
    }
}
