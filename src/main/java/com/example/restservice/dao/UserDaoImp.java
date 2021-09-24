package com.example.restservice.dao;

import com.example.restservice.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class UserDaoImp implements UserDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        String query ="FROM User";
        return  entityManager.createQuery(query).getResultList();
    }

    @Override
    public User getUserById(int id) {
        String query = String.format("FROM User U WHERE U.id = %d", id);
        return (User) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = entityManager.find(User.class,id);
        entityManager.remove(user);
    }

    @Override
    public void createUser(User user) {
        entityManager.merge(user);
    }

    @Override
    public User getUserByEmail(String email) {
        String query = String.format("FROM User U WHERE U.email like '%s'", email);
        return (User) entityManager.createQuery(query).getSingleResult();
    }

}
