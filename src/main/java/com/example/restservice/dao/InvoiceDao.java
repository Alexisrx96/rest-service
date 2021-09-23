package com.example.restservice.dao;

import com.example.restservice.models.Invoice;

import java.util.List;

public interface InvoiceDao {

    List<Invoice> getInvoices();
    Invoice getInvoice(int id);
    void createInvoice(Invoice invoice);
    void deleteInvoice(int id);
    void updateInvoice(Invoice invoice);
}
