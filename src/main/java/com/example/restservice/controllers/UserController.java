package com.example.restservice.controllers;

import com.example.restservice.dao.UserDao;
import com.example.restservice.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.GET)
    public User getUser(@PathVariable int id){
        return userDao.getUser(id);
    }

    @RequestMapping(value = "api/users",method = RequestMethod.GET)
    public List<User> getUsers(){
        return userDao.getUsers();
    }

    @RequestMapping(value = "api/users",method = RequestMethod.POST)
    public void createUser(@RequestBody User user){
        userDao.createUser(user);
    }

    @RequestMapping(value = "api/users/{id}",method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable int id){
        userDao.deleteUser(id);
    }

    @RequestMapping(value = "api/users",method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user){

    }
}
