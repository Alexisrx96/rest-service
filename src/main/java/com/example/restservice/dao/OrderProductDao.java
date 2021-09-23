package com.example.restservice.dao;

import com.example.restservice.models.OrderProduct;

import java.util.List;

public interface OrderProductDao {

    List<OrderProduct> getOrderProducts();
    OrderProduct getOrderProduct(int id);
    void createOrderProduct(OrderProduct orderProduct);
    void  deleteOrderProduct(int id);
    void updateOrderProduct(OrderProduct orderProduct);
}
