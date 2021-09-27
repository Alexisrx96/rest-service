package com.example.restservice.controllers;

import com.example.restservice.dao.RoleDao;
import com.example.restservice.dao.UserDao;
import com.example.restservice.models.NewUserCreated;
import com.example.restservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    UserDao userDao;
    @Autowired
    RoleDao roleDao;
    @Autowired
    BCryptPasswordEncoder encoder;

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.GET)
    public User getUserById(@PathVariable int id){
        return userDao.getUserById(id);
    }

    @RequestMapping(value = "api/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(value = "create-account",method = RequestMethod.POST)
    public void createAccount(@RequestBody NewUserCreated newUserCreated){

        User user = new User();
        user.setPassword(encoder.encode(newUserCreated.getPassword()));
        user.setDireccion(newUserCreated.getDirection());
        user.setEmail(newUserCreated.getUsername());
        user.setFirstName(newUserCreated.getFirstName());
        user.setLastName(newUserCreated.getLastName());
        user.setIdRol(roleDao.getRole(2));
        userDao.createUser(user);
    }

    @RequestMapping(value = "create-admin",method = RequestMethod.POST)
    public void createAdmin(@RequestBody NewUserCreated newUserCreated){

        User user = new User();
        user.setPassword(encoder.encode(newUserCreated.getPassword()));
        user.setDireccion(newUserCreated.getDirection());
        user.setEmail(newUserCreated.getUsername());
        user.setFirstName(newUserCreated.getFirstName());
        user.setLastName(newUserCreated.getLastName());
        user.setIdRol(roleDao.getRole(1));
        userDao.createUser(user);
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        userDao.deleteUser(id);
    }

    @RequestMapping(value = "api/users",method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user){
        user.setPassword(encoder.encode(user.getPassword()));
        userDao.updateUser(user);
    }

    @RequestMapping(value = "api/users/{email}",method = RequestMethod.GET)
    public User getUserByEmail(@PathVariable String email){
        return userDao.getUserByEmail(email);
    }

}
