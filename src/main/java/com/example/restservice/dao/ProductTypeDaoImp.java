package com.example.restservice.dao;

import com.example.restservice.models.ProductType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;


@Repository
@Transactional
public class ProductTypeDaoImp implements ProductTypeDao {

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<ProductType> getProductTypes() {
        String query = "FROM ProductType";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public ProductType getProductType(int id) {
        String query = String.format("FROM ProductType PT WHERE PT.id = %d", id);
        return (ProductType) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void updateProductType(ProductType productType) {
        entityManager.merge(productType);
    }

    @Override
    public void deleteProductType(int id) {
        ProductType productType = entityManager.find(ProductType.class, id);
        entityManager.remove(productType);
    }

    @Override
    public void createProductType(ProductType productType) {
        entityManager.merge(productType);
    }
}
