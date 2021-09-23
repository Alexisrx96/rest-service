package com.example.restservice.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "order_product")
@Entity
public class OrderProduct {

    @EmbeddedId
    private OrderProductId id;

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }
}