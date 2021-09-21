package com.example.restservice.models;

import javax.persistence.*;

@Table(name = "invoice")
@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_invoice", nullable = false)
    private Integer id;

    @Column(name = "payment_type", length = 45)
    private String paymentType;

    @Column(name = "total")
    private Double total;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_order", nullable = false)
    private Order idOrder;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_payment", nullable = false)
    private PaymentType idPayment;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_user", nullable = false)
    private User idUser;

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public PaymentType getIdPayment() {
        return idPayment;
    }

    public void setIdPayment(PaymentType idPayment) {
        this.idPayment = idPayment;
    }

    public Order getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Order idOrder) {
        this.idOrder = idOrder;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

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