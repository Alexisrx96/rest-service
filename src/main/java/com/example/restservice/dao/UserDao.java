package com.example.restservice.dao;

import com.example.restservice.models.User;

import java.util.List;

public interface UserDao {
    public List<User> getUsers();
    public User getUser(int id);;
    public void updateUser(User user);
    public void deleteUser(int id);
}
