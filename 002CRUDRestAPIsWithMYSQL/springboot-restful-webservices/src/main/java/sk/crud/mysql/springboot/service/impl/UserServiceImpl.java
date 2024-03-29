package sk.crud.mysql.springboot.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import sk.crud.mysql.springboot.entity.User;
import sk.crud.mysql.springboot.repository.UserRepository;
import sk.crud.mysql.springboot.service.UserService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


//25. Build Create User REST API
@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    //25. Build Create User REST API

    private UserRepository userRepository;
    /*@Autowired
    we don't have to use again @Autowired annotation to inject this dependency because whenever
spring will find spring bean, it has only one parameterized constructor
then spring will automatically inject the dependency.
We don't have to use add @Autowired annotation
     */
    @Override
    public User createUser(User user) {
        return userRepository.save(user);

    }


    //26. Build Get User By ID REST API
    @Override
    public User getUserByUUID(UUID uuid) {
        Optional<User> optionalUser = userRepository.findById(uuid);

        return optionalUser.get();
    }


    //27. Build Get All Users REST API
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }




}
