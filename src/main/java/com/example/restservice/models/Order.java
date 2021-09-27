package com.example.restservice.models;

import javax.persistence.*;

@Table(name = "orders")
@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_order", nullable = false)
    private Integer id;

    @Column(name = "orders_date", length = 45)
    private String ordersDate;

    @Column(name = "orders_status", length = 45)
    private String ordersStatus;

    @Column(name = "orders_delivaddress", length = 80)
    private String ordersDelivaddress;

    @Column(name = "id_payment")
    private Integer idPayment;

    @Column(name = "id_user")
    private Integer idUser;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Integer getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(Integer idPayment) {
        this.idPayment = idPayment;
    }

    public String getOrdersDelivaddress() {
        return ordersDelivaddress;
    }

    public void setOrdersDelivaddress(String ordersDelivaddress) {
        this.ordersDelivaddress = ordersDelivaddress;
    }

    public String getOrdersStatus() {
        return ordersStatus;
    }

    public void setOrdersStatus(String ordersStatus) {
        this.ordersStatus = ordersStatus;
    }

    public String getOrdersDate() {
        return ordersDate;
    }

    public void setOrdersDate(String ordersDate) {
        this.ordersDate = ordersDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}