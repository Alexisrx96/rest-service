package com.example.restservice.controllers;

import com.example.restservice.dao.PaymentTypeDao;
import com.example.restservice.models.PaymentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PaymentTypeController {

    @Autowired
    PaymentTypeDao paymentTypeDao;

    @RequestMapping(value = "api/paymentTypes/{id}",method = RequestMethod.GET)
    public PaymentType getPaymentType(@PathVariable int id){
        return paymentTypeDao.getPaymentType(id);
    }

    @RequestMapping(value = "api/paymentTypes",method = RequestMethod.GET)
    public List<PaymentType> getPaymentTypes(){
        return paymentTypeDao.getPaymentTypes();
    }

    @RequestMapping(value = "api/paymentTypes",method = RequestMethod.POST)
    public void createPaymentType(@RequestBody PaymentType paymentType){
        paymentTypeDao.createPaymentType(paymentType);
    }

    @RequestMapping(value = "api/paymentTypes/{id}",method = RequestMethod.DELETE)
    public void deletePaymentType(@PathVariable int id){
        paymentTypeDao.deletePaymentType(id);
    }

    @RequestMapping(value = "api/paymentTypes/",method = RequestMethod.PUT)
    public void updatePaymentType(@RequestBody PaymentType paymentType){
        paymentTypeDao.updatePaymentType(paymentType);
    }
}
