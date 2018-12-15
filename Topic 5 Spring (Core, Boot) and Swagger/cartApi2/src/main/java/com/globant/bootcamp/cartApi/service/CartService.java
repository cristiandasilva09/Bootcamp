/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.cartApi.service;

import com.globant.bootcamp.cartApi.model.Cart;
import com.globant.bootcamp.cartApi.model.Product;
import com.globant.bootcamp.cartApi.repository.CartRepository;
import com.globant.bootcamp.cartApi.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class CartService {

    private final CartRepository repository;
    private final ProductRepository repositoryP;
    @Autowired
    public CartService(final CartRepository repository,final ProductRepository repositoryP) {
        this.repository = repository;
        this.repositoryP = repositoryP;
    }
    
     

    public List<Cart> findAllCarts() {
        return repository.findAll();
    }

    public Cart findCartById(final Long idCart) {
        List<Cart> listCart = repository.findAll();

        for (Cart obj : listCart) {
            if (obj.getIdCart() == idCart) {
                return obj;
            }

        }
        return null;
    }

    public Cart createCart(final Cart cart) {

        return repository.save(cart);
    }

    public void deleteCart(final Cart cart) {
        repository.delete(cart);
    }

    public List<Product> findAllProducts(Long idCart) {
        List<Cart> listCart = repository.findAll();

        for (Cart obj : listCart) {
            if (obj.getIdCart() == idCart) {
                return obj.getListProducts();
            }
        }
        //Optional<Cart> c=repository.findById(idCart);
        return null;
    }

    public Product findProductById(final Long idCart, final Long idProduct) {
        List<Cart> listCart = repository.findAll();

        for (Cart obj : listCart) {
            if (obj.getIdCart() == idCart) {
                List<Product> listProd = obj.getListProducts();
                for (Product objP : listProd) {
                    if (objP.getIdProduct() == idProduct) {
                        return objP;
                    }
                }
            }
        }

        return null;
    }

    public void addProduct(final Long idCart, final Product product) {
        List<Cart> listCart = repository.findAll();

        for (Cart obj : listCart) {
            if (obj.getIdCart() == idCart) {
                  List<Product> listProd = obj.getListProducts();
                  listProd.add(product);
                  product.setCart(obj);
                  List<Product> listProds =repositoryP.findAll();
                repositoryP.save(product);
                //   product.setCart(obj.getIdCart());
                 //obj.calculateTotal();
            }
        }

    }

    public void deleteProduct(final Long idCart, final Product product) {
        List<Cart> listCart = repository.findAll();

        for (Cart obj : listCart) {
            if (obj.getIdCart() == idCart) {
                List<Product> listProd = obj.getListProducts();
                listProd.remove(product);
                List<Product> listProds =repositoryP.findAll();
                repositoryP.delete(product);
                //  hibernate:delete from "CartProduct" where "CartID"=obj.getIdCart() and "idProduct" =product.getIdProduct();
            }
        }

    }

}
