/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cart.CartApi;

import java.util.List;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Cristian
 */
@RestController
@RequestMapping(
        path = "/cart/product",
        produces = MediaType.APPLICATION_JSON_VALUE)
public class CartController {
    private final CartService service;
    
       public CartController(final CartService service) {
        this.service = service;
    }
    
      @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getProducts() {
        return service.findAllProducts();
    }
    @GetMapping("/{idProduct}")
    @ResponseStatus(HttpStatus.OK)
    private Product getPersonById(@PathVariable("idProduct") final Long id) {
        final Product product = service.findProductById(id);
        if (Objects.isNull(product)) {
            throw new ProductNotFoundException("PRODUCT ID NOT FOUND: " + id);
        }
        return product;
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Product postPerson(@RequestBody final Product product) {
                

        return service.createProduct(product);
    }
    
    @PutMapping("/{idProduct}")
    @ResponseStatus(HttpStatus.CREATED)
    public Product putPerson(@PathVariable(name = "idProduct") final Long id,
                            @RequestBody final Product product) {
        product.setIdProduct(id);
        final Product updated = service.updateProduct(product);
        if (Objects.isNull(updated)) {
            throw new ProductNotFoundException("PRODUCT ID NOT FOUND: " + id);
        }
        return updated;
    }
    @DeleteMapping("/{idProduct}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteProduct(@PathVariable(name = "idProduct") final Long id,
                            @RequestBody final Product product) {
        if(Objects.isNull(product)){
            throw new ProductNotFoundException("PRODUCT ID NOT FOUND: " + id);
        }
        service.deleteProduct(product);
        
    }
    
    
     @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }
}    
