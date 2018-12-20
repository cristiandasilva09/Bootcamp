/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.service;

import com.globant.bootcamp.shoppingCartApi.conectionDB.ConectionBD;
import com.globant.bootcamp.shoppingCartApi.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class ProductService {
    
    
    
public List<Product> findAllProducts() throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from product");
        List<Product> listProd = new ArrayList();
        while (rs.next()) {
            Product product = new Product();
            product.setIdProduct(rs.getLong("idProduct"));
            product.setNameProduct(rs.getString("nameProduct"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getFloat("price"));
            listProd.add(product);
        }
        rs.close();
        return listProd;
    }




public Product findProductById(final Long id) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from product where idProduct="+id+"");
        Product product = new Product();
        while (rs.next()) {
           
            product.setIdProduct(rs.getLong("idProduct"));
            product.setNameProduct(rs.getString("nameProduct"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getFloat("price"));
           
        }
        rs.close();
        return product;
    }

public Product findProductByName(final String name) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from product where  nameProduct='" + name + "'");
        Product product = new Product();
        while (rs.next()) {
           
            product.setIdProduct(rs.getLong("idProduct"));
            product.setNameProduct(rs.getString("nameProduct"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getFloat("price"));
           
        }
        rs.close();
        return product;
    }

public List<Product> findProductsByCategory(final String category) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from product where  category='" + category + "'");
        List<Product> listProd = new ArrayList();
        while (rs.next()) {
            Product product = new Product();
            product.setIdProduct(rs.getLong("idProduct"));
            product.setNameProduct(rs.getString("nameProduct"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getFloat("price"));
            listProd.add(product);
        }
        rs.close();
        return listProd;
    }
public Product createProduct(final Product product) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("insert into product values(?, ?, ?, ?)");
        pConsulta.setLong(1, product.getIdProduct());
        pConsulta.setString(2, product.getNameProduct());
        pConsulta.setString(3, product.getCategory());
        pConsulta.setFloat(4, product.getPrice());
        pConsulta.executeUpdate();
        return product;
    }
public Product updateProduct(final Product product) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("update product set nameProduct=?,category=?,price=? where idProduct=?");
        pConsulta.setString(1, product.getNameProduct());
        pConsulta.setString(2, product.getCategory());
        pConsulta.setFloat(3, product.getPrice());
        pConsulta.setLong(4, product.getIdProduct());
        pConsulta.executeUpdate();
        return product;
    }
public void deleteProduct(final Product product) throws SQLException {
        Connection conn;

        conn = ConectionBD.getConnection();

        PreparedStatement pConsulta = conn.prepareStatement("delete from product where idProduct=" + product.getIdProduct() + "");
        pConsulta.executeUpdate();
    }

}
