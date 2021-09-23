package com.example.restservice.dao;

import com.example.restservice.models.Order;

import java.util.List;

public interface OrderDao {

    List<Order> getOrders();
    Order getOrder(int id);
    void updateOrder(Order order);
    void deleteOrder(int id);
    void createOrder(Order order);

}
