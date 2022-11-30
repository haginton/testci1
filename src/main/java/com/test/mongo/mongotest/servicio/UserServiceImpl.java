package com.test.mongo.mongotest.servicio;

import com.test.mongo.mongotest.dto.UserDto;
import com.test.mongo.mongotest.model.User;
import com.test.mongo.mongotest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(String id) {
        return userRepository.findById(id);
    }

    @Override
    public User createUser(UserDto userDto) {
        return userRepository.createUser(userDto);
    }

    @Override
    public User updateUser(String id, UserDto userDto) {
        return userRepository.updateUser(id, userDto);
    }

    @Override
    public Boolean deleteUser(String id) {
        return userRepository.deleteUser(id);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
