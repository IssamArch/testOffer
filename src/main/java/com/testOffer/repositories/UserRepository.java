package com.testOffer.repositories;

import com.testOffer.models.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
   repository interface for mongodb
    - findByLogin
    - findByid
 */

public interface UserRepository extends MongoRepository<User, String> {

    public User findByLogin(String login);
    public User findByid(String id);



}
