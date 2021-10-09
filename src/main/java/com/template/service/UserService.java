package com.template.service;

import com.template.controller.input.RegisterUserRequest;
import com.template.controller.output.RegisterUserResponse;
import com.template.exc.NotFoundException;
import com.template.page.UserProfilePage;

public interface UserService {

    /**
     * Load user's page by user id
     *
     * @param id User id
     * @return UserPage
     */
    UserProfilePage userPageById(Integer id) throws NotFoundException;

    RegisterUserResponse registerUser(RegisterUserRequest request);
}
