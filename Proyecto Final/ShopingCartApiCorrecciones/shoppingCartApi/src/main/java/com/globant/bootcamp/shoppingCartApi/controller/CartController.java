/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.controller;

import com.globant.bootcamp.shoppingCartApi.model.Cart;
import com.globant.bootcamp.shoppingCartApi.model.Product;
import com.globant.bootcamp.shoppingCartApi.model.ProductCart;
import com.globant.bootcamp.shoppingCartApi.model.User;
import com.globant.bootcamp.shoppingCartApi.service.CartService;
import com.globant.bootcamp.shoppingCartApi.service.ProductService;
import com.globant.bootcamp.shoppingCartApi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Logger;
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
import org.springframework.web.server.ResponseStatusException;

/**
 *
 * @author Cristian
 */
@RestController
@RequestMapping(
        path = "api/cart",
        produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = "carts", description = "Carts of the cart API", produces = "application/json")
public class CartController {

    private final CartService service;
    private final UserService serviceU;
    private final ProductService serviceP;
    private final static Logger LOGGER2 = Logger.getLogger("CartController");

    public CartController(final CartService service, final UserService serviceU, final ProductService productP) {
        this.service = service;
        this.serviceU = serviceU;
        this.serviceP = productP;
    }

    @GetMapping("getCarts/{idUser}")
    @ApiOperation(value = "Get User carts", notes = "Returns all Carts of a user")
    @ApiResponses({
        @ApiResponse(code = 204, message = "No carts registred")
        ,
        @ApiResponse(code = 204, message = "User not Found")
        ,@ApiResponse(code = 200, message = "Exits one cart at least")

    })
    public ResponseEntity<List<Cart>> getCartsByClient(@PathVariable("idUser") final Long idUser) throws SQLException {
        List<Cart> cart = service.findAllCartsByClient(idUser);

        if (cart.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<List<Cart>>(cart, HttpStatus.OK);
    }

    @GetMapping("getCart/{idCart}")
    @ApiOperation(value = "Get Cart", notes = "Returns Cart")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Cart not found")
        ,@ApiResponse(code = 200, message = "Exits one cart at least")

    })
    public ResponseEntity<Cart> getCart(@PathVariable("idCart") final Long idCart) throws SQLException {
        Cart cart = service.getCart(idCart);
        if (cart.getIdCart() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CART NOT FOUND");
        }

        return new ResponseEntity<Cart>(cart, HttpStatus.OK);
    }

    @GetMapping("/getProducts/{idCart}")
    @ApiOperation(value = "Get Products  of a cart", notes = "Returns all products of a cart")
    @ApiResponses({
        @ApiResponse(code = 204, message = "No product registred")
        ,
        @ApiResponse(code = 404, message = "Cart not found")
        ,@ApiResponse(code = 200, message = "Exits one product at least")

    })
    public ResponseEntity<List<ProductCart>> getProductsByCart(@PathVariable("idCart") final Long idCart) throws SQLException {
        List<ProductCart> cart = service.findAllProductByCart(idCart);
        Cart c = service.getCart(idCart);
        if (c.getIdCart() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CART NOT FOUND: " + idCart);
        }
        if (cart.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<ProductCart>>(cart, HttpStatus.OK);
    }

    @GetMapping("/getTotalCost/{idCart}")
    @ApiOperation(value = "Get cost of a cart", notes = "Returns cost of a cart")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Cart not found")
        ,@ApiResponse(code = 409, message = "Cart is empty")
        ,@ApiResponse(code = 200, message = "Exits one product at least")

    })
    public ResponseEntity getCostByCart(@PathVariable("idCart") final Long idCart) throws SQLException {
        Cart c = service.getCart(idCart);
        if (c.getIdCart() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CART NOT FOUND");
        }
        Float cost = service.getTotalCostCart(idCart);
        if (cost == 0) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "CART IS EMPTY PLEASE ADD PRODUCTS");
        }
        return new ResponseEntity(cost, HttpStatus.OK);
    }

    @GetMapping("/getRecomendedProducts/{idUser}")
    @ApiOperation(value = "Get Recomended product for a user", notes = "Returns all products recomended pro previus buy")
    @ApiResponses({
        @ApiResponse(code = 404, message = "User not found")
        ,
        @ApiResponse(code = 404, message = "Dont have any previus order")
        ,
        @ApiResponse(code = 404, message = "Sonr have product relationated")
        ,@ApiResponse(code = 200, message = "ok and the products")

    })
    public ResponseEntity<List<Product>> getRecomendedProductsByUser(@PathVariable("idUser") final Long idUser) throws SQLException {
        List<Product> prodRec = service.findrecomendedProduct(idUser);
        User u = serviceU.findUsernById(idUser);
        List<Cart> listCart = service.findAllCartsByClient(idUser);
        if (u.getIdUser() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "USER NOT FOUND");
        }
        if (listCart.isEmpty()) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "USER DONT HAVE ANY PREVIUS ORDER");
        }
        if (prodRec.size() == 0) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "DONT HAVE PRODUCT RELATIONATED TO YOUR PREVIUS ORDERS");
        }
        return new ResponseEntity<List<Product>>(prodRec, HttpStatus.OK);
    }

    @ApiOperation(value = "Save Cart", notes = "add cart to a user")
    @ApiResponses({
        @ApiResponse(code = 409, message = "cart already saved")
        ,
        @ApiResponse(code = 409, message = "cart id already exist")
        ,
        @ApiResponse(code = 200, message = "Return the cart and ok")
        ,
             @ApiResponse(code = 404, message = "User not found")

    })
    @PostMapping
    public ResponseEntity<Cart> saveCart(@RequestBody final Cart cart) throws SQLException {
        List<Cart> listCart = service.findAllCartsByClient(cart.getIdUser());
        User u = serviceU.findUsernById(cart.getIdUser());

        if (u.getIdUser() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "USER NOT FOUND");
        }
            for (Cart obj : listCart) {
            if (obj.isBuyed() == false) {
                throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"USER HAVE A CART SAVED BUY THE CART O DELETE THE CART SAVED: "+obj.isBuyed());
            }
            if (cart.getIdCart() == obj.getIdCart()) {
             throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"CART ID ALREADY EXIST FOR THIS USER: " + cart.getIdCart());  
            }

        }
         //Cart c =service.getCart(cart.getIdCart());
         
        service.saveCart(cart);
        return new ResponseEntity<Cart>(cart, HttpStatus.CREATED);
    }

    @ApiOperation(value = "Add ProductCart", notes = "add product to a cart")
    @ApiResponses({
        @ApiResponse(code = 409, message = "product already saved")
        ,@ApiResponse(code = 200, message = "Return the product and ok")
        ,
             @ApiResponse(code = 404, message = "user not found")
        ,@ApiResponse(code = 404, message = "Cart not found")
        ,
             @ApiResponse(code = 404, message = "Product dont exist")
    })
    @PostMapping("/{idProduct}")
    public ResponseEntity<ProductCart> addProductCart(@PathVariable(name = "idProduct") final Long id,
            @RequestBody final ProductCart product) throws SQLException {
        List<ProductCart> listProd = service.findAllProductByCart(product.getIdCart());
        User u = serviceU.findUsernById(product.getIdUser());
        if (u.getIdUser() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "USER NOT FOUND");
        }
        Cart c = service.getCart(product.getIdCart());
        if (c.getIdCart() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CART NOT FOUND");
        }
        Product p = serviceP.findProductById(product.getIdProduct());
        if (p.getIdProduct() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "PRODUCT DONT EXIST");
        }
        for (ProductCart obj : listProd) {
            if (product.getIdProduct() == obj.getIdProduct()) {
                throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "PRODUCT ALREADY ADDED: " + product.getIdProduct());
            }

        }

        service.addProductCart(product.getIdProduct(), product);
        service.setTotalCost(product);
        return new ResponseEntity<ProductCart>(service.findProductByCart(product.getIdCart(), product.getIdProduct()), HttpStatus.CREATED);

    }

    @PutMapping("changeQuiantityProduct/{idProduct}")
    @ApiOperation(value = "Modify Product", notes = "Modify quiantity and total import or a Product ")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Product not found")
        ,@ApiResponse(code = 200, message = "Return the product modify and ok")

    })
    public ResponseEntity<ProductCart> putProduct(@PathVariable(name = "idProduct") final Long id,
            @RequestBody ProductCart product) throws SQLException {
        Product p = serviceP.findProductById(product.getIdProduct());
        
        
        if (p.getIdProduct() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "PRODUCT  NOT FOUND: " + product.getIdProduct());
        }
        Cart c=service.getCart(product.getIdCart());
        User u =serviceU.findUsernById(product.getIdUser());
        if(u.getIdUser()==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "USER  NOT FOUND: " +product.getIdUser());
        }
        if(c.getIdCart()==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CART  NOT FOUND: " + c.getIdCart());
        }
        if(product.getIdCart()==c.getIdCart()&(c.isBuyed()==true)){
            throw new ResponseStatusException(
                        HttpStatus.CONFLICT, "CART ALREADY BUYED CANT MODIFY A PRODUCT OF A CART BUY: ");
        }
        service.changeQuiantityProductCart(product.getIdProduct(), product);
        service.setTotalCost(product);

        return new ResponseEntity<ProductCart>(service.findProductByCart(product.getIdCart(), product.getIdProduct()), HttpStatus.OK);

    }

    @PutMapping("buyCart/{idCart}")
    @ApiOperation(value = "Buy Cart", notes = "Buy a cart ")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Cart not found")
        ,
        @ApiResponse(code = 409, message = "Cart already buyed")
        ,
        @ApiResponse(code = 409, message = "Cart empy")
        ,@ApiResponse(code = 200, message = "Return the product modify and ok")

    })
    public ResponseEntity<Cart> buyCart(@PathVariable(name = "idCart") final Long idCart,@RequestBody final Long idUser) throws SQLException {
        Cart c = service.getCart(idCart);
        if (c.getIdCart() == null||(c.getIdUser()!=idUser)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CART  NOT FOUND FOR THIS USER: " + idCart);
        }
        if (c.isBuyed() == true) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "CART  ALREADY BUYED:" + idCart);
        }
        float totalCost = service.getTotalCostCart(c.getIdCart());
        if (totalCost == 0) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "CART IS EMPTY PLEASE ADD PRODUCTS");
        }
        User u=serviceU.findUsernById(c.getIdUser());
        System.out.println("money user"+u.getMoney());
        if(totalCost>u.getMoney()){
             throw new ResponseStatusException(
                    HttpStatus.CONFLICT,"USER CANT BUY THE CART,COST IS BIGGER THAN USER MONEY");
        }
        else{
          float newMontoUser =u.getMoney()-totalCost;
        Cart buyed = service.buyCart(c);
        System.out.println("newMonto"+newMontoUser);
       // u.setMoney(newMontoUser);
        serviceU.updateUserMoney(newMontoUser, u.getIdUser());
            System.out.println(u.getMoney());
            return new ResponseEntity<Cart>(buyed, HttpStatus.OK);
        }
    }

    @DeleteMapping("/{idProduct}")
    @ApiOperation(value = "Delete ProductCart", notes = "Delete product of a cart")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Product not found")
        ,@ApiResponse(code = 409, message = "Cart is empy")
        ,
        @ApiResponse(code = 404, message = "Cart already buyed")
        ,
        @ApiResponse(code = 200, message = "Return  product Deleted and ok")

    })
    public ResponseEntity<Product> deleteProduct(@PathVariable(name = "idProduct") final Long idProduct, @RequestBody final Long idCart) throws SQLException {
        Product product = serviceP.findProductById(idProduct);
        if (product.getIdProduct() == null) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "PRODUCT NOT FOUND: " + idProduct);
        }
        float totalCost = service.getTotalCostCart(idCart);
        if (totalCost == 0) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "CART IS EMPTY PLEASE ADD PRODUCTS");
        }
        Cart c = service.getCart(idCart);
        if (c.isBuyed() == true) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CART  ALREADY BUYED,CANT DELETE PRODUCT OF A CART BUYED:");
        }
        service.deleteProductCat(idCart, idProduct);
        return new ResponseEntity<Product>(product, HttpStatus.OK);

    }

    @DeleteMapping("deleteCart/{idCart}")
    @ApiOperation(value = "Delete Cart", notes = "Delete a cart")
    @ApiResponses({
        @ApiResponse(code = 404, message = "Product not found")
        ,
        @ApiResponse(code = 200, message = "Return  product Deleted and ok")

    })
    public ResponseEntity<Cart> deleteCart(@PathVariable(name = "idCart") final long idCart,@RequestBody final Long idUser) throws SQLException {
        Cart c = service.getCart(idCart);
        Long idU=c.getIdUser();
        User u =serviceU.findUsernById(idUser);
        if(u.getIdUser()==null){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "USER NOT FOUND: " + idUser);
        }
        if (c.getIdCart() == null &(idU!=idUser)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "CART NOT FOUND FOR THIS USER: " + idUser);
        }
        service.deleteCart(c,idUser);
        return new ResponseEntity<Cart>(c, HttpStatus.OK);

    }

}
