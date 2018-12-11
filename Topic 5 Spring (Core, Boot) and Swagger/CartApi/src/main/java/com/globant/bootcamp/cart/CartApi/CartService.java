/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cart.CartApi;

import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class CartService {
      private final ProductRepository repository;
      
       @Autowired
    public CartService(final ProductRepository repository) {
        this.repository = repository;
    }
       public List<Product> findAllProducts() {
        return repository.findAll();
    }
    
       public Product findProductById(final Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public Product createProduct(final Product product) {
        product.setIdProduct(null);
        return repository.save(product);
    }

    public Product updateProduct(final Product product) {
        final Product original = findProductById(product.getIdProduct());
        if (Objects.isNull(original)) {
            return null;
        }
        return repository.save(product);
    }
     public void deleteProduct(final Product product) {
        final Product original = findProductById(product.getIdProduct());
        if (Objects.isNull(original)) {
          System.out.println("Product not found");
        }
         repository.delete(product);
    }
    
}
