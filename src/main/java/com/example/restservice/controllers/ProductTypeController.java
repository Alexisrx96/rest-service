package com.example.restservice.controllers;

import com.example.restservice.dao.ProductTypeDao;
import com.example.restservice.models.ProductType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class ProductTypeController {

    @Autowired
    ProductTypeDao productTypeDao;

    @RequestMapping(value = "api/productTypes", method = RequestMethod.GET)
    public List<ProductType> getProductTypes() {
        return productTypeDao.getProductTypes();
    }
}
