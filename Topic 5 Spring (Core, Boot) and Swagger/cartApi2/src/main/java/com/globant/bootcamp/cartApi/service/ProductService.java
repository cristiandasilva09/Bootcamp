/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cartApi.service;

import com.globant.bootcamp.cartApi.model.Product;
import com.globant.bootcamp.cartApi.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class ProductService {
      private final ProductRepository repository;

    @Autowired
    public ProductService(final ProductRepository repository) {
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
        return repository.save(product);
    }
    
     public Product updateProduct(final Product product) {
         List<Product> listProd = repository.findAll();
         for(Product obj:listProd){
             if(obj.getIdProduct()==product.getIdProduct()){
                obj.setNameProduct(product.getNameProduct());
                obj.setCategory(product.getCategory());
                obj.setPrice(product.getPrice());
                return repository.save(obj);
             }
         }
         return null;
    }
     public void deleteProduct(final Product product) {
       repository.delete(product);
    }
    
}
