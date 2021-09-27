package com.example.restservice.models;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Table(name = "order_product")
@Entity
public class OrderProduct {
    @EmbeddedId
    private OrderProductId id;

    @Column(name = "product_quantity")
    private Integer productQuantity;

    @Column(name = "product_price")
    private Double productPrice;

    public Double getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    public OrderProductId getId() {
        return id;
    }

    public void setId(OrderProductId id) {
        this.id = id;
    }
}