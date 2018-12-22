/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "product-cart")
@ApiModel(value = "productCart entity", description = "Complete data of a entity productCart")
public class ProductCart {

   @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ApiModelProperty(value = "The id of the cart", required = false)
    private Long idCart;
    @ApiModelProperty(value = "The id of the product", required = false)
    private Long idProduct;
    @ApiModelProperty(value = "The id of the user", required = false)
    private Long idUser;

    @ApiModelProperty(value = "The quantity of the product", required = true)
    private int quantity;
    @ApiModelProperty(value = "The total of the products", required = true)
    private float totalImport;
    @Transient
    private String nameProduct;
    private float price;
    private String category;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    
    
    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return price;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }
     
    public ProductCart() {
    }

    public ProductCart(Long idCart, Long idProduct, int quantity, float totalImport) {
        this.idCart = idCart;
        this.idProduct = idProduct;
        this.quantity = quantity;
        this.totalImport = totalImport;
    }

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalImport() {
        return totalImport;
    }

    public void setTotalImport(float totalImport) {
        this.totalImport = totalImport;
    }

}
