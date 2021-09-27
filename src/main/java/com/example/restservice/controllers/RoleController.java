package com.example.restservice.controllers;

import com.example.restservice.dao.RoleDao;
import com.example.restservice.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class RoleController {

    @Autowired
    RoleDao roleDao;

    @RequestMapping(value = "api/roles/{id}", method = RequestMethod.GET)
    public Role getRole(@PathVariable int id){
        return roleDao.getRole(id);
    }

    @RequestMapping(value = "api/roles", method = RequestMethod.GET)
    public List<Role> getRoles(){
        return roleDao.getRoles();
    }

    @RequestMapping(value = "api/roles", method = RequestMethod.POST)
    public void createRole(@RequestBody Role role){
        roleDao.createRole(role);
    }

    @RequestMapping(value = "api/roles/{id}", method = RequestMethod.DELETE)
    public void deleteRole(@PathVariable int id){
        roleDao.deleteRole(id);
    }

    @RequestMapping(value = "api/roles", method = RequestMethod.PUT)
    public void updateRole(@RequestBody Role role){

    }
}
