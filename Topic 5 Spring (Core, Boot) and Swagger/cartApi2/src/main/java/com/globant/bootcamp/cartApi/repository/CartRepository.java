/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cartApi.repository;

import com.globant.bootcamp.cartApi.model.Cart;
import com.globant.bootcamp.cartApi.model.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Cristian
 */
public interface CartRepository extends JpaRepository<Cart, Long> {
List<Cart> findAll();
}