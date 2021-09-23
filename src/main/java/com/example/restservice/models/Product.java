package com.example.restservice.models;
import javax.persistence.*;

@Table(name = "product")
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Product", nullable = false)
    private Integer id;

    @Column(name = "name", length = 45)
    private String name;

    @Column(name = "price")
    private Double price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_product_type", nullable = false)
    private ProductType idProductType;

    public ProductType getIdProductType() {
        return idProductType;
    }

    public void setIdProductType(ProductType idProductType) {
        this.idProductType = idProductType;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}