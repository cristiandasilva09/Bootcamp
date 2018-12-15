/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cartApi.controller;

import com.globant.bootcamp.cartApi.model.Product;
import com.globant.bootcamp.cartApi.service.ProductService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Objects;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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
        path = "api/product",
        produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "products", description = "Products cart API", produces = "application/json")
public class ProductController {
    private final ProductService service;

    public ProductController(final ProductService service) {
        this.service = service;
    }
    @GetMapping
    @ApiOperation(value = "Get Products", notes = "Returns all Products")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No products registred"),@ApiResponse(code = 200, message = "Exits one product at least")
           
    })
    public ResponseEntity<List<Product>> getProducts() {
        List<Product> product = service.findAllProducts();
        if (product.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Product>>(product, HttpStatus.OK);
    }
     @GetMapping("/{idProduct}")
     @ApiOperation(value = "Get Product", notes = "Returns  Product by id")
    @ApiResponses({
            @ApiResponse(code = 404, message = "No products found"),@ApiResponse(code = 200, message = "Return the product and ok")
           
    })
     public ResponseEntity<Product> getProductById(@PathVariable("idProduct") final Long id) {
        final Product product = service.findProductById(id);
        if (Objects.isNull(product)) {
            throw new ProductFoundException("PRODUCT ID NOT FOUND: " + id);
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
     @ApiOperation(value = "Add Product", notes = "Create product")
    @ApiResponses({
            @ApiResponse(code = 409, message = "Product already exist"),@ApiResponse(code = 200, message = "Return the product and ok")
           
    })
    @PostMapping("/{idProduct}")
    public ResponseEntity<Product> postProduct(@RequestBody final Product product) {
        List<Product> products = service.findAllProducts();
        for (Product obj : products) {
            if (obj.getIdProduct() == product.getIdProduct()) {
                throw new ProductExistException("PRODUCT ID ALREADY EXIST: " + product.getIdProduct());
            }
           
        }

        service.createProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.CREATED);
    }
    
    
       @PutMapping("/{idProduct}")
        @ApiOperation(value = "Put Product", notes = "Modify product")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Product not found"),@ApiResponse(code = 200, message = "Return the product modify and ok")
           
    }) 
       public ResponseEntity<Product> putProduct(@PathVariable(name = "idProduct") final Long id,
            @RequestBody final Product product) {
                
                 Product products = service.updateProduct(product);
                  if (Objects.isNull(product)) {
            throw new ProductFoundException("PRODUCT  NOT FOUND: ");
        }
        return new ResponseEntity<Product>(product, HttpStatus.OK);
                 
    }
    
    @DeleteMapping("/{idProduct}")
       @ApiOperation(value = "Delete Product", notes = "Delete product by id")
    @ApiResponses({
            @ApiResponse(code = 404, message = "Product not found"),@ApiResponse(code = 200, message = "Return  product Deleted and ok")
           
    })
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "idProduct") final Long id) {
        Product product = service.findProductById(id);
        if (Objects.isNull(product)) {
            throw new ProductFoundException("PRODUCT NOT FOUND: " + id);
        }
        service.deleteProduct(product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);

    }
    
    
    
    @ResponseStatus(HttpStatus.NOT_FOUND)
        public static class ProductFoundException extends RuntimeException {

            public ProductFoundException(String message) {
                super(message);
            }
        }
    
            @ResponseStatus(HttpStatus.CONFLICT)
        public static class ProductExistException extends RuntimeException {

            public ProductExistException(String message) {
                super(message);
            }
        }
    
}
