package com.example.restservice.models;

import javax.persistence.*;

@Table(name = "product_type")
@Entity
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_product_type", nullable = false)
    private Integer id;

    @Column(name = "type", length = 45)
    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}