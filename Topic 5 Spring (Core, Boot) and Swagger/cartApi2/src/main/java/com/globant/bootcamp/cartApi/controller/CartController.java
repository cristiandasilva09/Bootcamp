/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cartApi.controller;

import com.globant.bootcamp.cartApi.model.Cart;
import com.globant.bootcamp.cartApi.model.Product;
import com.globant.bootcamp.cartApi.service.CartService;
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
        path = "api/cart",
        produces = MediaType.APPLICATION_JSON_VALUE)

@Api(value = "carts", description = "Carts API", produces = "application/json")
public class CartController {

    private final CartService service;

    public CartController(final CartService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Get Carts", notes = "Returns all Carts")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No carts registred"),@ApiResponse(code = 200, message = "Exits one car at least")
           
    })
    public ResponseEntity<List<Cart>> getCarts() {
        List<Cart> carts = service.findAllCarts();
        if (carts.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);
    }

    @GetMapping("/{idCart}")
    @ApiOperation(value = "Get Cart", notes = "Returns cart by id")
    @ApiResponses({
            @ApiResponse(code = 404, message = "No cart found"),@ApiResponse(code = 200, message = "Return the cart and ok")
           
    })
    public ResponseEntity<Cart> getCartById(@PathVariable("idCart") final Long id) {
        final Cart cart = service.findCartById(id);
        if (Objects.isNull(cart)) {
            throw new CartFoundException("CART ID NOT FOUND: " + id);
        }
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @PostMapping("/{idCart}")
    @ApiOperation(value = "Post Cart", notes = "Create cart")
    @ApiResponses({
            @ApiResponse(code = 409, message = "Cart already exist"),@ApiResponse(code = 200, message = "Return the cart and ok")
           
    })
    public ResponseEntity<Cart> postCart(@RequestBody final Cart cart) {
        List<Cart> carts = service.findAllCarts();
        for (Cart obj : carts) {
            if (obj.getIdCart() == cart.getIdCart()) {
                throw new CartExistException("CART ID ALREADY EXIST: " + cart.getIdCart());
            }

        }

        service.createCart(cart);
        return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
    }

    @DeleteMapping("/{idCart}")
    @ApiOperation(value = "Delete Cart", notes = "Delete cart by id")
    @ApiResponses({
            @ApiResponse(code = 404, message = "No cart found"),@ApiResponse(code = 200, message = "Return the cart and delete")
           
    })
    public ResponseEntity<Cart> deleteCart(@PathVariable(name = "idCart")
            final Long id
    ) {
        Cart cart = service.findCartById(id);
        if (Objects.isNull(cart)) {
            throw new CartFoundException("CART NOT FOUND: " + id);
        }
        service.deleteCart(cart);
        return new ResponseEntity<Cart>(cart, HttpStatus.OK);

    }
    
    @GetMapping("/{idCart}/productos")
    @ApiOperation(value = "Get Cart products", notes = "Returns list of product by cart")
    @ApiResponses({
            @ApiResponse(code = 404, message = "No cart found"),@ApiResponse(code = 200, message = "Return the cart and ok")
           
    })
    public ResponseEntity<List<Product>> getProducts(@PathVariable("idCart") final Long id) {
        final Cart cart = service.findCartById(id);
        if (Objects.isNull(cart)) {
            throw new CartFoundException("CART ID NOT FOUND: " + id);
        }
        return new ResponseEntity<List<Product>>(cart.getListProducts(), HttpStatus.OK);
    }
    
    @GetMapping("/{idCart}/{idProduct}")
    @ApiOperation(value = "Get Cart product", notes = "Return  product by  id of a cart")
    @ApiResponses({
            @ApiResponse(code = 404, message = "No cart found"),@ApiResponse(code = 404, message = "No product found"),
            @ApiResponse(code = 200, message = "Return the cart and ok")
           
    })
    public ResponseEntity<Product> getProductById(@PathVariable("idCart") final Long id,@PathVariable("idProduct") final Long idProduct) {
        final Cart cart = service.findCartById(id);
        if (Objects.isNull(cart)) {
            throw new CartFoundException("CART ID NOT FOUND: " + id);
        }
        List<Product> listProd=cart.getListProducts();
        for(Product obj:listProd){
            if(obj.getIdProduct()==idProduct)
            {
                return new ResponseEntity<Product>(obj, HttpStatus.OK);
            }
        }
          throw new CartFoundException("PRODUCT ID NOT FOUND: " + id);
    }
    
    @PostMapping("/{idCart}/{idProduct}")
    @ApiOperation(value = "Add Cart product", notes = "Add a  product to the cart")
    @ApiResponses({
            @ApiResponse(code = 404, message = "No cart found"),@ApiResponse(code = 200, message = "Return the cart and ok")
           
    })
    public ResponseEntity<Product> addProduct(@PathVariable("idCart") final Long id,@RequestBody final Product product) {
       final Cart cart = service.findCartById(id);
      if (Objects.isNull(cart)) {
            throw new CartFoundException("CART ID NOT FOUND: " + id);
        }
      service.addProduct(id, product);
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
    
    @DeleteMapping("/{idCart}/{idProduct}")
    @ApiOperation(value = "Delete Cart product", notes = "Delete a  product to the cart")
    @ApiResponses({
            @ApiResponse(code = 404, message = "No cart found"),@ApiResponse(code = 404, message = "No product found"),
            @ApiResponse(code = 200, message = "Return the cart and ok")
           
    })
    public ResponseEntity<Product> deleteProduct(@PathVariable("idCart") final Long id,@PathVariable("idProduct") final Long idProduct) {
       final Cart cart = service.findCartById(id);
        if (Objects.isNull(cart)) {
            throw new CartFoundException("CART ID NOT FOUND: " + id);
        }
        List<Product> listProd=cart.getListProducts();
        for(Product obj:listProd){
            if(obj.getIdProduct()==idProduct)
            {
                service.deleteProduct(id, obj);
            return new ResponseEntity<Product>(obj, HttpStatus.OK);
            }
        }
            throw new CartFoundException("PRODUCT ID NOT FOUND: " + id);

        }
    

   
    
     @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ProductNotFoundException extends RuntimeException {
        public ProductNotFoundException(String message) {
            super(message);
        }
    }
     
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class CartFoundException extends RuntimeException {

        public CartFoundException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    public static class CartExistException extends RuntimeException {

        public CartExistException(String message) {
            super(message);
        }
    }
}
