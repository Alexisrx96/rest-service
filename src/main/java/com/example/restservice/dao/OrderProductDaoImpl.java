package com.example.restservice.dao;

import com.example.restservice.models.OrderProduct;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OrderProductDaoImpl implements OrderProductDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<OrderProduct> getOrderProducts() {
        String query = "FROM OrderProduct";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public OrderProduct getOrderProduct(int id) {
        String query = String.format("FROM OrderProduct OP WHERE OP.id = %d", id);
        return (OrderProduct) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void createOrderProduct(OrderProduct orderProduct) {
        entityManager.persist(orderProduct);
    }

    @Override
    public void deleteOrderProduct(int id) {
        OrderProduct orderProduct = entityManager.find(OrderProduct.class,id);
        entityManager.remove(orderProduct);
    }

    @Override
    public void updateOrderProduct(OrderProduct orderProduct) {
        entityManager.merge(orderProduct);
    }
}
