package com.test.mongo.mongotest.repository;

import com.test.mongo.mongotest.dto.UserDto;
import com.test.mongo.mongotest.model.User;
import com.test.mongo.mongotest.repository.mongorepository.UserMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserRepositoryImpl implements UserRepository{

    private final UserMongoRepository userMongoRepository;

    @Autowired
    public UserRepositoryImpl(UserMongoRepository userMongoRepository) {
        this.userMongoRepository = userMongoRepository;
    }

    @Override
    public List<User> findAll() {
        return userMongoRepository.findAll();
    }

    @Override
    public User findById(String id) {
        Optional<User> userFound = userMongoRepository.findById(id);
        if (userFound.isPresent()){
            return userFound.get();
        }else {
            return null;
        }
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = new User(userDto);
        return userMongoRepository.save(user);
    }

    @Override
    public User updateUser(String id, UserDto userDto) {
        User userFound = findById(id);
        if (userFound != null){
            userFound.setFullName(userDto.getFullName());
            userFound.setBirthDate(userDto.getBirthDate());
            userFound.setEmail(userDto.getEmail());
            return userMongoRepository.save(userFound);
        }else {
            return null;
        }
    }

    @Override
    public Boolean deleteUser(String id) {
        User userFound = findById(id);
        if (userFound != null){
            userMongoRepository.delete(userFound);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public User findByEmail(String email) {
        Optional<User> userFound = userMongoRepository.findByEmail(email);
        if (userFound.isPresent()){
            return userFound.get();
        }else{
            return null;
        }
    }
}
