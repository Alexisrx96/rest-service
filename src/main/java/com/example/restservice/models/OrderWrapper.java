package com.example.restservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class OrderWrapper {
    private String ordersDate;
    private String ordersStatus;
    private String ordersDelivaddress;
    private Integer idPayment;
    private Integer idUser;
    private List<OrderProductWrapper> productWrappers;
}
