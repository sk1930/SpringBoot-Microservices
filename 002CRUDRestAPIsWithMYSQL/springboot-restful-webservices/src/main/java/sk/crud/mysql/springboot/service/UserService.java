package sk.crud.mysql.springboot.service;


import sk.crud.mysql.springboot.entity.User;

import java.util.List;
import java.util.UUID;

//25. Build Create User REST API
public interface UserService {
    //25. Build Create User REST API

    User createUser(User user);



    //26. Build Get User By ID REST API
    User getUserByUUID(UUID uuid);


    //27. Build Get All Users REST API
    List<User> getAllUsers();





}
