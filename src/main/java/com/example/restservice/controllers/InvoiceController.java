package com.example.restservice.controllers;

import com.example.restservice.dao.InvoiceDao;
import com.example.restservice.models.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceController {

    @Autowired
    InvoiceDao invoiceDao;

    @RequestMapping(value = "api/invoices/{id}", method = RequestMethod.GET)
    public Invoice getInvoice(@PathVariable int id){
        return invoiceDao.getInvoice(id);
    }

    @RequestMapping(value = "api/invoices", method = RequestMethod.GET)
    public List<Invoice> getInvoices(){
        return invoiceDao.getInvoices();
    }

    @RequestMapping(value = "api/invoices", method = RequestMethod.POST)
    public void createInvoice(@RequestBody Invoice invoice){
        invoiceDao.createInvoice(invoice);
    }

    @RequestMapping(value = "api/invoices/{id}", method = RequestMethod.DELETE)
    public void deleteInvoice(@PathVariable int id){
        invoiceDao.deleteInvoice(id);
    }

    @RequestMapping(value = "api/invoices", method = RequestMethod.PUT)
    public void updateInvoice(@RequestBody Invoice invoice){

    }
}
