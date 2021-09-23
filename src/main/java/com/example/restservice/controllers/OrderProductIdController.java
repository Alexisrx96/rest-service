package com.example.restservice.controllers;

import com.example.restservice.dao.OrderProductDao;
import com.example.restservice.dao.OrderProductIdDao;
import com.example.restservice.models.OrderProduct;
import com.example.restservice.models.OrderProductId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderProductIdController {

    @Autowired
    OrderProductIdDao orderProductIdDao;

    @RequestMapping(value = "api/orderproductsid/{id}",method = RequestMethod.GET)
    public OrderProductId getOrderProduct(@PathVariable int id){
        return orderProductIdDao.getOrderProductId(id);
    }

    @RequestMapping(value = "api/orderproductsid",method = RequestMethod.GET)
    public List<OrderProductId> getOrderProducts(){
        return orderProductIdDao.getOrderProductId();
    }

    @RequestMapping(value = "api/orderproductsid",method = RequestMethod.POST)
    public void createOrderProductId(@RequestBody OrderProductId orderProductId){
        orderProductIdDao.createOrderProductId(orderProductId);
    }

    @RequestMapping(value = "api/orderproductsid/{id}",method = RequestMethod.DELETE)
    public void deleteOrderProductId(@PathVariable int id){
        orderProductIdDao.deleteOrderProductId(id);
    }

    @RequestMapping(value = "api/orderproductsid",method = RequestMethod.PUT)
    public void updateOrderProductId(@RequestBody OrderProductId orderProductId){

    }
}
