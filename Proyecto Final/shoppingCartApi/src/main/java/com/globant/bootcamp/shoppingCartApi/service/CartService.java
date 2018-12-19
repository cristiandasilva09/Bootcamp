/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.service;

import com.globant.bootcamp.shoppingCartApi.ConectionBD.ConectionBD;
import com.globant.bootcamp.shoppingCartApi.model.Cart;
import com.globant.bootcamp.shoppingCartApi.model.ProductCart;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class CartService {

    public List<Cart> findAllCartsByClient(final Long idUser) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from cart  where cart.idUser=" + idUser + "");
        List<Cart> listCart = new ArrayList();
        while (rs.next()) {
            Cart cart = new Cart();
            cart.setIdUser(idUser);
            cart.setIdCart(rs.getLong("idCart"));
            cart.setBuyed(rs.getBoolean("buyed"));
            cart.setDateBuy(rs.getDate("dateBuy"));
            listCart.add(cart);
        }
        rs.close();
        return listCart;
    }

    public List<ProductCart> findAllProductByCart(final Long idCart) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from `product-cart` JOIN `product` ON `product`.idProduct= `product-cart`.idProduct where `product-cart`.idCart=" + idCart + "");
        List<ProductCart> listProd = new ArrayList();
        while (rs.next()) {
            ProductCart product = new ProductCart();
            product.setIdCart(idCart);
            product.setIdUser(rs.getLong("idUser"));
            product.setIdProduct(rs.getLong("idProduct"));
            product.setNameProduct(rs.getString("nameProduct"));
            product.setQuantity(rs.getInt("quantity"));
            product.setPrecio(rs.getFloat("price"));
            product.setTotalImport(rs.getFloat("totalImport"));
            listProd.add(product);
        }
        rs.close();
        return listProd;
    }

    public ProductCart findProductByCart(final Long idCart, final Long idProduct) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from `product-cart` JOIN `product` ON `product`.idProduct= `product-cart`.idProduct where `product-cart`.idCart=" + idCart + " and"
                + "`product-cart`.idProduct=" + idProduct + "");
        ProductCart product = new ProductCart();
        while (rs.next()) {

            product.setIdCart(idCart);
            product.setIdUser(rs.getLong("idUser"));
            product.setIdProduct(rs.getLong("idProduct"));
            product.setNameProduct(rs.getString("nameProduct"));
            product.setQuantity(rs.getInt("quantity"));
            product.setPrecio(rs.getFloat("price"));
            product.setTotalImport(rs.getFloat("totalImport"));

        }
        rs.close();
        return product;
    }

    public Cart getCart(final Long idCart) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from cart  where cart.idCart=" + idCart + "");
        Cart cart = new Cart();
        while (rs.next()) {

            cart.setIdUser(rs.getLong("idUser"));
            cart.setIdCart(rs.getLong("idCart"));
            cart.setBuyed(rs.getBoolean("buyed"));
            cart.setDateBuy(rs.getDate("dateBuy"));

        }
        rs.close();
        return cart;
    }

    public Cart saveCart(final Cart cart) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("insert into cart  values(?, ?, ?, ?)");
        cart.setBuyed(false);
        cart.setDateBuy(null);
        pConsulta.setLong(1, cart.getIdUser());
        pConsulta.setLong(2, cart.getIdCart());
        pConsulta.setBoolean(3, cart.isBuyed());
        pConsulta.setDate(4, null);
        pConsulta.executeUpdate();
        return cart;
    }

    public Cart buyCart(final Cart cart) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("update cart set buyed=?,dateBuy=? where idCart="+cart.getIdCart()+"");
        pConsulta.setInt(1,1);
        pConsulta.setDate(2, new java.sql.Date(System.currentTimeMillis()));
        pConsulta.executeUpdate();
        cart.setDateBuy(new java.sql.Date(System.currentTimeMillis()));
        cart.setBuyed(true);
        return cart;
    }

    public void addProductCart(final Long id, final ProductCart product) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("insert into  `product-cart` values(?,?,?,?,?)");
        pConsulta.setLong(1, product.getIdCart());
        pConsulta.setLong(2, product.getIdUser());
        pConsulta.setLong(3, product.getIdProduct());
        pConsulta.setInt(4, product.getQuantity());
        pConsulta.setFloat(5, product.getTotalImport());
        pConsulta.executeUpdate();

    }

    public void changeQuiantityProductCart(final Long id, final ProductCart product) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("update `product-cart` set quantity =? where `product-cart`.idProduct=" + product.getIdProduct()
                + " and `product-cart`.idCart=" + product.getIdCart() + " and `product-cart`.idUser=" + product.getIdUser() + "");
        pConsulta.setInt(1, product.getQuantity());
        pConsulta.executeUpdate();

    }

    public void setTotalCost(final ProductCart product) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select price from product where idProduct=" + product.getIdProduct() + "");
        while (rs.next()) {
            product.setTotalImport(product.getQuantity() * (rs.getFloat("price")));
        }
        PreparedStatement pConsulta = conn.prepareStatement("update `product-cart`set totalImport=" + product.getTotalImport() + " where `product-cart`.idProduct=" + product.getIdProduct() + "");
        pConsulta.executeUpdate();
        rs.close();

    }
    

    public float getTotalCostCart(final Long idCart) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select sum(totalImport) from `product-cart` where idCart=" + idCart + "");
        rs.next();
        float cost=rs.getFloat(1);
        
        rs.close();
        return cost;
    }

    public void deleteCart(final Cart cart) throws SQLException {
        Connection conn;

        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta2 = conn.prepareStatement("delete from `product-cart` where `product-cart`.idCart=" + cart.getIdCart() + "");
        pConsulta2.executeUpdate();
        PreparedStatement pConsulta = conn.prepareStatement("delete from cart where idCart=" + cart.getIdCart() + "");
        pConsulta.executeUpdate();
        
      /*  PreparedStatement pConsulta3 = conn.prepareStatement("delete from user where idCart=" + cart.getIdCart() + "");
        pConsulta3.executeUpdate();*/
    }

    public void deleteProductCat(final Long idCart, final Long idProd) throws SQLException {
        Connection conn;

        conn = ConectionBD.getConnection();

        PreparedStatement pConsulta = conn.prepareStatement("delete from `product-cart` where idcart=" + idCart + " and idProduct=" + idProd + "");
        pConsulta.executeUpdate();
    }

}
