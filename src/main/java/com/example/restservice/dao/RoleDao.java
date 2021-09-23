package com.example.restservice.dao;

import com.example.restservice.models.Role;

import java.util.List;

public interface RoleDao {

    List<Role> getRoles();
    Role getRole(int id);
    void createRole(Role role);
    void deleteRole(int id);
    void updateRole(Role role);
}
