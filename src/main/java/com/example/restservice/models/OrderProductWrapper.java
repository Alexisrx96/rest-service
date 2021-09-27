package com.example.restservice.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderProductWrapper {
    private Integer idProduct;
    private Integer productQuantity;
    private Double productPrice;
}
