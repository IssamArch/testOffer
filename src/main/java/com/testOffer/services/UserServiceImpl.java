package com.testOffer.services;

import com.testOffer.models.User;
import com.testOffer.repositories.UserRepository;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**

   Implimentation user Service
 */


@Service
public class UserServiceImpl implements UserService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getUserById(String id)  {
        LOGGER.debug("Getting user={}", id);
        return userRepository.findByid(id);

    }

    @Override
    public User getUserByLogin(String login) {
        LOGGER.debug("Getting user={}",login);
        return userRepository.findByLogin(login);


    }

    @Override
    public Collection<User> getAllUsers() {
        LOGGER.debug("Getting all users");
        return userRepository.findAll(new Sort("login"));
    }

    @Override
    public User create(User user) {
        LOGGER.debug("Create User ");
        User u = new User();
        u.setLogin(user.getLogin());
        u.setPassword(user.getPassword());
        u.setFirstName(user.getLastName());
        u.setLastName(user.getLastName());
        u.setAge(user.getAge());
        u.setCountry(user.getCountry());
        // save a couple of customers
        return userRepository.save(u);
    }
}