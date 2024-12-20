package dev.computer.shop.models;

import java.math.BigDecimal;

import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class ProductModel {
    
    private BigDecimal price;    

    public ProductModel() {
    }
    
    public ProductModel(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

}
