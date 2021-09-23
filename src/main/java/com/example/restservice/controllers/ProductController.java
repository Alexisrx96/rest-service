package com.example.restservice.controllers;

import com.example.restservice.dao.ProductDao;
import com.example.restservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    ProductDao productDao;

    @RequestMapping(value = "api/products/{id}",method = RequestMethod.GET)
    public Product getProduct(@PathVariable int id){
        return productDao.getProduct(id);
    }

    @RequestMapping(value = "api/products",method = RequestMethod.GET)
    public List<Product> getProducts(){
        return productDao.getProducts();
    }

    @RequestMapping(value = "api/products",method = RequestMethod.POST)
    public void createUser(@RequestBody Product product){
        productDao.createProduct(product);
    }

    @RequestMapping(value = "api/products/{id}",method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable int id){
        productDao.deleteProduct(id);
    }

    @RequestMapping(value = "api/products",method = RequestMethod.PUT)
    public void updateUser(@RequestBody Product product){

    }

}
