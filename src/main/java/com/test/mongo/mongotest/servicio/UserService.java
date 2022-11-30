package com.test.mongo.mongotest.servicio;

import com.test.mongo.mongotest.dto.UserDto;
import com.test.mongo.mongotest.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();
    User findById(String id);
    User createUser(UserDto userDto);
    User updateUser(String id, UserDto userDto);
    Boolean deleteUser(String id);
    User findByEmail(String email);
}
