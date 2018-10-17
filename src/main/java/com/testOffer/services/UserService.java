package com.testOffer.services;

import com.testOffer.models.User;


import java.util.Collection;
/**
   User service to manage user

 */

public interface UserService {
    User getUserById(String id);

    User getUserByLogin(String login);

    Collection<User> getAllUsers();

    User create(User u);

}
