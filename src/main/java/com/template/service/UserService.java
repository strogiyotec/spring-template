package com.template.service;

import com.template.exc.NotFoundException;
import com.template.page.UserProfilePage;

//TODO: Implement
public interface UserService {

    /**
     * Load user's page by user id
     *
     * @param id User id
     * @return UserPage
     */
    UserProfilePage userPageById(Integer id) throws NotFoundException;
}
