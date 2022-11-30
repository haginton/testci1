package com.test.mongo.mongotest.repository.mongorepository;

import com.test.mongo.mongotest.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UserMongoRepository extends MongoRepository<User, String> {

    Optional<User> findByEmail(String email);
}
