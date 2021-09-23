package com.example.restservice.controllers;

import com.example.restservice.dao.OrderProductDao;
import com.example.restservice.models.OrderProduct;
import com.example.restservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderProductController {

    @Autowired
    OrderProductDao orderProductDao;

    @RequestMapping(value = "api/orderproducts/{id}",method = RequestMethod.GET)
    public OrderProduct getOrderProduct(@PathVariable int id){
        return orderProductDao.getOrderProduct(id);
    }

    @RequestMapping(value = "api/orderproducts",method = RequestMethod.GET)
    public List<OrderProduct> getOrderProducts(){
        return orderProductDao.getOrderProducts();
    }

    @RequestMapping(value = "api/orderproducts",method = RequestMethod.POST)
    public void createOrderProduct(@RequestBody OrderProduct orderProduct){
        orderProductDao.createOrderProduct(orderProduct);
    }

    @RequestMapping(value = "api/orderproducts/{id}",method = RequestMethod.DELETE)
    public void deleteOrderProduct(@PathVariable int id){
        orderProductDao.deleteOrderProduct(id);
    }

    @RequestMapping(value = "api/orderproducts",method = RequestMethod.PUT)
    public void updateOrderProduct(@RequestBody OrderProduct orderProduct){

    }
}
