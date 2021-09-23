package com.example.restservice.dao;

import com.example.restservice.models.OrderProductId;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class OrderProductIdDaoImpl implements OrderProductIdDao{

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<OrderProductId> getOrderProductId() {
        String query = "FROM OrderProductId";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public OrderProductId getOrderProductId(int id) {
        String query = String.format("FROM Product P WHERE P.id = %d", id);
        return (OrderProductId) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void createOrderProductId(OrderProductId orderProductId) {
        entityManager.merge(orderProductId);
    }

    @Override
    public void deleteOrderProductId(int id) {
        OrderProductId orderProductId = entityManager.find(OrderProductId.class,id);
        entityManager.remove(orderProductId);
    }

    @Override
    public void updateOrderProductId(OrderProductId orderProductId) {
        entityManager.merge(orderProductId);
    }
}
