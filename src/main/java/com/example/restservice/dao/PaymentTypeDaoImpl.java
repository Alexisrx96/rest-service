package com.example.restservice.dao;

import com.example.restservice.models.PaymentType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class PaymentTypeDaoImpl implements PaymentTypeDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<PaymentType> getPaymentTypes() {
        String query = "FROM PaymentType";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public PaymentType getPaymentType(int id) {
        String query = String.format("FROM PaymentType P WHERE P.id = %d", id);
        return (PaymentType) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void createPaymentType(PaymentType paymentType) {
        entityManager.merge(paymentType);
    }

    @Override
    public void deletePaymentType(int id) {
        PaymentType paymentType = entityManager.find(PaymentType.class,id);
        entityManager.remove(paymentType);
    }

    @Override
    public void updatePaymentType(PaymentType paymentType) {
        entityManager.merge(paymentType);
    }
}
