package com.example.restservice.models;

import javax.persistence.*;

@Table(name = "payment_type")
@Entity
public class PaymentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_payment", nullable = false)
    private Integer id;

    @Column(name = "payment_type", length = 45)
    private String paymentType;

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}