package com.example.restservice.dao;

import com.example.restservice.models.Role;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class RoleDaoImpl implements RoleDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Role> getRoles() {
        String query = "FROM Role";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Role getRole(int id) {
        String query = String.format("FROM Role R WHERE R.id = %d", id);
        return (Role) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void createRole(Role role) {
        entityManager.merge(role);
    }

    @Override
    public void deleteRole(int id) {
        Role role = entityManager.find(Role.class,id);
        entityManager.remove(role);
    }

    @Override
    public void updateRole(Role role) {
        entityManager.merge(role);
    }
}
