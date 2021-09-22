package com.example.restservice.dao;

import com.example.restservice.models.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class ProductDaoImp implements ProductDao{

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public List<Product> getProducts() {
        String query = "FROM Product";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Product getProduct(int id) {
        String query = String.format("FROM Product P WHERE P.id = %d", id);
        return (Product) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void updateProduct(Product product) {
        entityManager.merge(product);
    }

    @Override
    public void deleteProduct(int id) {
        Product product = entityManager.find(Product.class,id);
        entityManager.remove(product);
    }

    @Override
    public void createProduct(Product product) {
        entityManager.merge(product);
    }
}
