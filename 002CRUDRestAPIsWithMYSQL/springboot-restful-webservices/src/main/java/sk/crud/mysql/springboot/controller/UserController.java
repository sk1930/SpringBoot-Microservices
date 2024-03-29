package sk.crud.mysql.springboot.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.crud.mysql.springboot.entity.User;
import sk.crud.mysql.springboot.service.UserService;

import java.util.List;
import java.util.UUID;

//25. Build Create User REST API
@RestController
@AllArgsConstructor
@RequestMapping("api/users")
public class UserController {
    //25. Build Create User REST API
    private UserService userService;

    //25. Build Create User REST API
    @PostMapping("create")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User savedUser = userService.createUser(user);
        return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
    }


    // http://localhost:8090/api/users/8b8d7cc4-44cf-442d-8321-a23a6bbef613
    //26. Build Get User By ID REST API
    @GetMapping("{id}")
    public ResponseEntity<User> getUserByID(@PathVariable("id") UUID uuid){
        //26. Build Get User By ID REST API
        User user = userService.getUserByUUID(uuid);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }


    //27. Build Get All Users REST API
    /// here we dont give any url so
    // http://localhost:8090/api/users
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users,HttpStatus.OK);
    }





}
