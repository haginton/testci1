package com.test.mongo.mongotest.servicio;

import com.test.mongo.mongotest.dto.UserDto;
import com.test.mongo.mongotest.model.User;
import com.test.mongo.mongotest.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class UserServiceImplTest {
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    private void setUp(){
        //userService = new UserServiceImpl(userRepository);
    }

    @Test
    @Order(1)
    public void get_all_users(){
        //Generation Mock
        List<User> userListMock = new ArrayList<>();
        userListMock.add(new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now()));
        userListMock.add(new User("Pepito2", "pepito2@mail.com", "132dfd*", LocalDate.now()));
        userListMock.add(new User("Pepito3", "pepito3@mail.com", "132dfd*", LocalDate.now()));
        userListMock.add(new User("Pepito4", "pepito4@mail.com", "132dfd*", LocalDate.now()));
        Mockito.when(userRepository.findAll()).thenReturn(userListMock);

        //Lista de usuarios simulada
        List<User> userListReturned = userService.findAll();

        //Lista de usuarios esperada
        List<User> userListExpected = new ArrayList<>();
        userListExpected.add(new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now()));
        userListExpected.add(new User("Pepito2", "pepito2@mail.com", "132dfd*", LocalDate.now()));
        userListExpected.add(new User("Pepito3", "pepito3@mail.com", "132dfd*", LocalDate.now()));
        userListExpected.add(new User("Pepito4", "pepito4@mail.com", "132dfd*", LocalDate.now()));

        Assertions.assertEquals(userListExpected, userListReturned);
        Assertions.assertTrue(userListReturned.size() > 0);
    }

    @Test
    @Order(2)
    public void find_user_by_id(){
        User userMock = new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());
        Mockito.when(userRepository.findById("123asd")).thenReturn(userMock);
        //Mockito.when(userRepository.findById(Mockito.anyString())).thenReturn(userMock);
        User userResult = userService.findById("123asd");

        User userExpected = new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());

        Assertions.assertEquals(userExpected, userResult);
        Assertions.assertEquals(userExpected.getFullName(), userResult.getFullName());
    }

    @Test
    @Order(3)
    public void create_user(){
        UserDto userDtoInput = new UserDto("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());
        User userMock = new User(userDtoInput);
        Mockito.when(userRepository.createUser(userDtoInput)).thenReturn(userMock);

        User userResult = userService.createUser(userDtoInput);

        User userExpected = new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());

        Assertions.assertEquals(userExpected, userResult);
        Assertions.assertEquals(userExpected.getEmail(), userResult.getEmail());
    }

    @Test
    @Order(4)
    public void update_user(){
        UserDto userDtoInput = new UserDto("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());
        User userMock = new User(userDtoInput);
        Mockito.when(userRepository.updateUser("123asd", userDtoInput)).thenReturn(userMock);

        User userResult = userService.updateUser("123asd", userDtoInput);

        User userExpected = new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());

        Assertions.assertEquals(userExpected, userResult);
    }

    @Test
    @Order(5)
    public void delete_user_by_id(){
        Mockito.when(userRepository.deleteUser("123asd")).thenReturn(false);

        Boolean isDeleted = userService.deleteUser("123asd");

        //Assertions.assertTrue(isDeleted);
        Assertions.assertFalse(isDeleted);
    }

    @Test
    @Order(6)
    public void find_user_by_email(){
        User userMock = new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());
        Mockito.when(userRepository.findByEmail("pepito1@mail.com")).thenReturn(userMock);

        User userResult = userService.findByEmail("pepito1@mail.com");

        User userExpected = new User("Pepito1", "pepito1@mail.com", "132dfd*", LocalDate.now());

        Assertions.assertEquals(userExpected, userResult);
        Assertions.assertEquals(userExpected.getBirthDate(), userResult.getBirthDate());
    }

}