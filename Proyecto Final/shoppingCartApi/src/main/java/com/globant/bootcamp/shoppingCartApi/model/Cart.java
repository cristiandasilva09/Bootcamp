/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.model;
;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
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
@ApiModel(value = "cart entity", description = "Complete data of a entity cart")
public class Cart {
    @EmbeddedId
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ApiModelProperty(value = "The id of the cart", required = false)
    private Long idCart;
   // @Id
   // @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(value = "The id of the user", required = false)
    private Long idUser;
   @ApiModelProperty(value = "The bollean buyed of a cart", required = false)
    private boolean buyed;
   @ApiModelProperty(value = "The Date of a cart", required = false)
    private Date DateBuy;
    
   public Cart(){
        
    }

    public Cart(Long idCart, Long idUser, boolean buyed, Date DateBuy) {
        this.idCart = idCart;
        this.idUser = idUser;
        this.buyed = buyed;
        this.DateBuy = DateBuy;
    }
    
    
    public Long getIdCart() {
        return idCart;
    }

    public void setIdCart(Long idCart) {
        this.idCart = idCart;
    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public boolean isBuyed() {
        return buyed;
    }

    public void setBuyed(boolean buyed) {
        this.buyed = buyed;
    }

    public Date getDateBuy() {
        return DateBuy;
    }

    public void setDateBuy(Date DateBuy) {
        this.DateBuy = DateBuy;
    }

    
 
}
