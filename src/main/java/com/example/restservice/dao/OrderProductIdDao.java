package com.example.restservice.dao;

import com.example.restservice.models.OrderProductId;

import java.util.List;

public interface OrderProductIdDao {

    List<OrderProductId> getOrderProductId();
    OrderProductId getOrderProductId(int id);
    void createOrderProductId(OrderProductId orderProductId);
    void deleteOrderProductId(int id);
    void updateOrderProductId(OrderProductId orderProductId);
}
