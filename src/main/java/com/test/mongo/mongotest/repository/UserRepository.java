package com.test.mongo.mongotest.repository;

import com.test.mongo.mongotest.dto.UserDto;
import com.test.mongo.mongotest.model.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();
    User findById(String id);
    User createUser(UserDto userDto);
    User updateUser(String id, UserDto userDto);
    Boolean deleteUser(String id);
    User findByEmail(String email);
}
