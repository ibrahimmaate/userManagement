package com.technos.userManagement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    /**
     * endpoint to call all users
     * @return
     */
    @GetMapping("/all")
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("{gender}")
    public List<User> getUsers(@PathVariable String gender){
        return userService.getAllUsersByGender(Gender.valueOf(gender.toUpperCase()));
    }

    /**
     * first endpoint to addUser with RequestBody
     * @param user
     * @return
     */
    @PostMapping("addUser")
    public ResponseEntity<String> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    /**
     * first endpoint to addUser with RequestBody and RequestParam with default value
     * @param gender
     * @param user
     * @return
     */
    @PostMapping("addUser1")
    public ResponseEntity<String> addUser(@RequestParam(value = "gender", defaultValue = "NOTASSIGNED") Gender gender,
                                          @RequestBody User user){
        user.setGender(gender);
        return userService.addUser(user);
    }

}
