/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cartApi.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.CascadeType.PERSIST;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "cart")
@ApiModel(value = "cart entity", description = "Complete data of a entity cart")
public class Cart {
        @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ApiModelProperty(value = "The id of the cart", required = false)
    private Long idCart;
    @JsonManagedReference
    @OneToMany(mappedBy ="cart" ,cascade = CascadeType.REMOVE,orphanRemoval =false)
  /*
    @JoinTable
  (
      name="CartProduct",
      joinColumns={ @JoinColumn(name="CartID", referencedColumnName="idCart") },
      inverseJoinColumns= @JoinColumn(name="ProductiD", referencedColumnName="idProduct", unique=true) 
  )
  */  
    private List<Product> listProducts = new ArrayList<Product>();
   /* 
    @Column
    private float total;
    
    public float getTotal() {
        return total;
    }

    public void setTotal() {
        this.calculateTotal();
        //this.total = total;
    }
    */
    public Cart(){
        
    }
    
    
    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

   public List<Product> getListProducts() {
        return listProducts;
    }

    public void setListProducts(List<Product> listProducts) {
        this.listProducts = listProducts;
    }
 
}
