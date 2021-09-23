package com.example.restservice.dao;

import com.example.restservice.models.Invoice;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
@Transactional
public class InvoiceDaoImpl implements InvoiceDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Invoice> getInvoices() {
        String query = "FROM Invoice";
        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Invoice getInvoice(int id) {
        String query = String.format("FROM Invoice I WHERE I.id = %d", id);
        return (Invoice) entityManager.createQuery(query).getSingleResult();
    }

    @Override
    public void createInvoice(Invoice invoice) {
        entityManager.merge(invoice);
    }

    @Override
    public void deleteInvoice(int id) {
        Invoice invoice = entityManager.find(Invoice.class,id);
        entityManager.remove(invoice);
    }

    @Override
    public void updateInvoice(Invoice invoice) {
        entityManager.merge(invoice);
    }
}
