package com.example.restservice.dao;

import com.example.restservice.models.PaymentType;

import java.util.List;

public interface PaymentTypeDao {

    List<PaymentType> getPaymentTypes();
    PaymentType getPaymentType(int id);
    void createPaymentType(PaymentType paymentType);
    void deletePaymentType(int id);
    void updatePaymentType(PaymentType paymentType);
}
