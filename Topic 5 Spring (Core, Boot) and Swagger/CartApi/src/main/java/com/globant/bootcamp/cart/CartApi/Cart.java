/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cart.CartApi;

import java.util.ArrayList;
import java.util.List;
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
@Table(name = "cart")
public class Cart {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long idCart;
   /* @Column(name = "listProducts")
    private List<Product> listProducts = new ArrayList<Product>();*/

    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

  /*  public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }*/
    
}
