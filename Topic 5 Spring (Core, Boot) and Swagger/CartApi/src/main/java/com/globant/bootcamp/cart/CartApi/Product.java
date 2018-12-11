/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cart.CartApi;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "product")
public class Product {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idProduct;
    @Column(name = "nameProduct")
    private String nameProduct;
    @Column(name = "category")
    private int  category;
    @Column(name = "price")
    private float  price;

    public Product() {
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public Product(long id, String name, int category, float price) {
        this.idProduct = id;
        this.nameProduct = name;
        this.category = category;
        this.price = price;
    }
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Product other = (Product) obj;
        if (this.idProduct != other.idProduct) {
            return false;
        }
        return true;
    }

    
}
