package com.example.restservice.dao;

import com.example.restservice.models.User;

import java.util.List;

public interface UserDao {
    List<User> getUsers();
    User getUser(int id);;
    void updateUser(User user);
    void deleteUser(int id);
    void createUser(User user);
}
