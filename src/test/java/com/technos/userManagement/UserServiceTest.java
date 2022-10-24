package com.technos.userManagement;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void addUserWithoutFirstName() {
        User user = new User();
        user.setId("fzfsd54fre6");
        user.setLastName("Lokis");
        user.setCountry("FranCE");
        user.setAge(23);

        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>("", HttpStatus.PRECONDITION_REQUIRED);
        assertEquals(stringResponseEntity.getStatusCode(), userService.addUser(user).getStatusCode());
    }

    @Test
    void addUserWithoutLastName() {
        User user = new User();
        user.setId("fzfsd54fre6");
        user.setFirstName("John");
        user.setCountry("FranCE");
        user.setAge(23);

        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>("", HttpStatus.PRECONDITION_REQUIRED);
        assertEquals(stringResponseEntity.getStatusCode(), userService.addUser(user).getStatusCode());
    }

    @Test
    void addUserWithoutCountry() {
        User user = new User();
        user.setId("fzfsd54fre6");
        user.setFirstName("John");
        user.setLastName("Lokis");
        user.setAge(22);

        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>("", HttpStatus.PRECONDITION_REQUIRED);
        assertEquals(stringResponseEntity.getStatusCode(), userService.addUser(user).getStatusCode());
    }

    @Test
    void addUserWithoutAge() {
        User user = new User();
        user.setId("fzfsd54fre6");
        user.setFirstName("John");
        user.setLastName("Lokis");
        user.setCountry("FranCe");

        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>("", HttpStatus.PRECONDITION_REQUIRED);
        assertEquals(stringResponseEntity.getStatusCode(), userService.addUser(user).getStatusCode());
    }

    @Test
    void addMinorUser() {
        User user = new User();
        user.setId("fzfsd54fre6");
        user.setFirstName("John");
        user.setLastName("Lokis");
        user.setCountry("FranCe");
        user.setAge(14);

        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>("", HttpStatus.NOT_ACCEPTABLE);
        assertEquals(stringResponseEntity.getStatusCode(), userService.addUser(user).getStatusCode());
    }

    @Test
    void addNonFrenchUser() {
        User user = new User();
        user.setId("fzfsd54fre6");
        user.setFirstName("John");
        user.setLastName("Lokis");
        user.setCountry("NorWaY");
        user.setAge(19);

        ResponseEntity<String> stringResponseEntity = new ResponseEntity<>("", HttpStatus.NOT_ACCEPTABLE);
        assertEquals(stringResponseEntity.getStatusCode(), userService.addUser(user).getStatusCode());
    }

}