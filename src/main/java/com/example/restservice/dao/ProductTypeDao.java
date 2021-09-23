package com.example.restservice.dao;

import com.example.restservice.models.ProductType;
import com.example.restservice.models.User;

import java.util.List;

public interface ProductTypeDao {

    List<ProductType> getProductTypes();
    ProductType getProductType(int id);;
    void updateProductType(ProductType productType);

    void deleteProductType(int id);
    void createProductType(ProductType productType);

}
