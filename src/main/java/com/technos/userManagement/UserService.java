package com.technos.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public List<User> getAllUsersByGender(Gender gender){
        return userRepository.findByGender(gender);
    }

    public ResponseEntity<String> addUser(User user){
        if (Utils.isEmptyOrBlankOrNull(user.getFirstName()) || Utils.isEmptyOrBlankOrNull(user.getLastName())
                || Utils.isEmptyOrBlankOrNull(user.getCountry()) || user.getAge() == 0) {
            return new ResponseEntity<>(
                    "Firstname, Lastname, age and country are required",
                    HttpStatus.PRECONDITION_REQUIRED);
        }
        if (user.getAge()<18) {
            return new ResponseEntity<>(
                    "Only adults (+18) can be registered",
                    HttpStatus.NOT_ACCEPTABLE);
        }

        if(user.getCountry().compareToIgnoreCase("france") != 0){
            return new ResponseEntity<>(
                    "Only people from France can be registered",
                    HttpStatus.NOT_ACCEPTABLE);
        }
        if(user.getGender().compareTo(Gender.FEMALE)!=0 && user.getGender().compareTo(Gender.MALE)!=0){
            user.setGender(Gender.NOTASSIGNED);
        }

        userRepository.save(user);

        return new ResponseEntity<>(
                "user " + user.getFirstName() + " " + user.getLastName() + " successfully added",
                HttpStatus.OK);
    }
}
