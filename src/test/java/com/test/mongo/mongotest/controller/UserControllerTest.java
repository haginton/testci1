package com.test.mongo.mongotest.controller;

import com.test.mongo.mongotest.dto.UserDto;
import com.test.mongo.mongotest.model.User;
import com.test.mongo.mongotest.servicio.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    @Test
    public void find_all_users(){
        List<User> userListMock = new ArrayList<>();
        //userListMock.add(new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now()));
        //userListMock.add(new User("Pepito2", "pepito2@mail.com", "132dfd*", LocalDate.now()));
        //userListMock.add(new User("Pepito3", "pepito3@mail.com", "132dfd*", LocalDate.now()));
        //userListMock.add(new User("Pepito4", "pepito4@mail.com", "132dfd*", LocalDate.now()));
        Mockito.when(userService.findAll()).thenReturn(userListMock);

        ResponseEntity<List<User>> listResponseEntityResult = userController.findAll();

        //Assertions.assertEquals(200, listResponseEntityResult.getStatusCodeValue());
        Assertions.assertEquals("The collection Users is empty", listResponseEntityResult.getBody());
    }

    @Test
    public void find_user_by_id(){
        User userMock = new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());
        //Mockito.when(userService.findById("123asd")).thenReturn(userMock);
        Mockito.when(userService.findById("123asd")).thenReturn(null);

        ResponseEntity<User> userResult = userController.findById("123asd");

        //Assertions.assertEquals(200, userResult.getStatusCodeValue());
        Assertions.assertEquals(404, userResult.getStatusCodeValue());
    }

    @Test
    public void create_user(){
        UserDto userDtoInput = new UserDto("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());
        User userMock = new User(userDtoInput);
        //Mockito.when(userService.createUser(userDtoInput)).thenReturn(userMock);
        Mockito.when(userService.createUser(userDtoInput)).thenReturn(null);

        ResponseEntity<User> userResult = userController.createUser(userDtoInput);

        //Assertions.assertEquals(201, userResult.getStatusCodeValue());
        Assertions.assertEquals(409, userResult.getStatusCodeValue());

    }

    @Test
    public void update_user_by_id(){
        UserDto userDtoInput = new UserDto("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());
        User userMock = new User(userDtoInput);
        Mockito.when(userService.updateUser("123asd", userDtoInput)).thenReturn(userMock);
        ResponseEntity<User> userUpdated = userController.updateUser("123asd", userDtoInput);

        User userUpdatedExpected = new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());

        Assertions.assertEquals(200, userUpdated.getStatusCodeValue());
        Assertions.assertEquals(userUpdatedExpected, userUpdated.getBody());
    }

    @Test
    public void delete_user_by_id(){
        //Mockito.when(userService.deleteUser("123asd")).thenReturn(true);
        Mockito.when(userService.deleteUser("123asd")).thenReturn(false);

        ResponseEntity<Boolean> isDeleted = userController.deleteUser("123asd");

        //Assertions.assertEquals(200, isDeleted.getStatusCodeValue());
        Assertions.assertEquals(404, isDeleted.getStatusCodeValue());
        Assertions.assertFalse(isDeleted.getBody());
    }


}