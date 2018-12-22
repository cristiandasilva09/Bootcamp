/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.service;

import com.globant.bootcamp.shoppingCartApi.conectionDB.ConectionBD;
import com.globant.bootcamp.shoppingCartApi.model.Cart;
import com.globant.bootcamp.shoppingCartApi.model.Product;
import com.globant.bootcamp.shoppingCartApi.model.ProductCart;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class CartService {

    private final static Logger LOGGER2 = Logger.getLogger("CartService");

    public List<Cart> findAllCartsByClient(final Long idUser) throws SQLException {
        Connection conn = null;
        List<Cart> listCart = new ArrayList();
        try {
            conn = ConectionBD.getConnection();

            CallableStatement pc = null;
            pc = conn.prepareCall("{call findAllCartsByUser(?)}");
            pc.setLong(1, idUser);
            ResultSet rs = pc.executeQuery();
            while (rs.next()) {
                Cart cart = new Cart();
                cart.setIdUser(idUser);
                cart.setIdCart(rs.getLong("idCart"));
                cart.setBuyed(rs.getBoolean("buyed"));
                cart.setDateBuy(rs.getDate("dateBuy"));
                listCart.add(cart);
            }
            return listCart;
        } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }
        return listCart;
    }

    public List<ProductCart> findAllProductByCart(final Long idCart) throws SQLException {
        Connection conn = null;
        List<ProductCart> listProd = new ArrayList();
        try {
            conn = ConectionBD.getConnection();

            CallableStatement pc = null;
            pc = conn.prepareCall("{call findAllProductsByCart(?)}");
            pc.setLong(1, idCart);
            ResultSet rs = pc.executeQuery();
            while (rs.next()) {
                ProductCart product = new ProductCart();
                product.setIdCart(idCart);
                product.setIdUser(rs.getLong("idUser"));
                product.setIdProduct(rs.getLong("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getFloat("price"));
                product.setTotalImport(rs.getFloat("totalImport"));
                listProd.add(product);
            }
            return listProd;
        } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }
        return listProd;
    }

    public ProductCart findProductByCart(final Long idCart, final Long idProduct) throws SQLException {
        Connection conn = null;
        ProductCart product = new ProductCart();
        try {
            conn = ConectionBD.getConnection();

            CallableStatement pc = null;
            pc = conn.prepareCall("{call findProductByCart(?,?)}");
            pc.setLong(1, idCart);
            pc.setLong(2, idProduct);
            ResultSet rs = pc.executeQuery();

            while (rs.next()) {

                product.setIdCart(idCart);
                product.setIdUser(rs.getLong("idUser"));
                product.setIdProduct(rs.getLong("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setQuantity(rs.getInt("quantity"));
                product.setPrice(rs.getFloat("price"));
                product.setTotalImport(rs.getFloat("totalImport"));
                product.setCategory(rs.getString("category"));

            }
            return product;
        } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }
        return product;
    }

    public Cart getCart(final Long idCart) throws SQLException {
        Connection conn = null;
        Cart cart = new Cart();
        try {
            conn = ConectionBD.getConnection();

            CallableStatement pc = null;
            pc = conn.prepareCall("{call getCart(?)}");
            pc.setLong(1, idCart);
            ResultSet rs = pc.executeQuery();
            while (rs.next()) {

                cart.setIdUser(rs.getLong("idUser"));
                cart.setIdCart(rs.getLong("idCart"));
                cart.setBuyed(rs.getBoolean("buyed"));
                cart.setDateBuy(rs.getDate("dateBuy"));

            }
            return cart;
        } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }
        return cart;
    }

    public Cart saveCart(final Cart cart) throws SQLException {
        Connection conn = null;
        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call saveCart(?,?,?,?)}");
            cart.setBuyed(false);
            cart.setDateBuy(null);
            pc.setLong(1, cart.getIdUser());
            pc.setLong(2, cart.getIdCart());
            pc.setBoolean(3, cart.isBuyed());
            pc.setDate(4, null);
            pc.executeUpdate();
        } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }
        return cart;
    }

    public Cart buyCart(final Cart cart) throws SQLException {
        Connection conn = null;
        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call buyCart(?,?,?,?)}");
            pc.setBoolean(1,true);
            pc.setDate(2, new java.sql.Date(System.currentTimeMillis()));
            pc.setLong(3, cart.getIdCart());
            pc.setLong(4, cart.getIdUser());
            pc.executeUpdate();
            cart.setBuyed(true);
            cart.setDateBuy(new java.sql.Date(System.currentTimeMillis()));
        } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }
        return cart;
    }

    public void addProductCart(final Long id, final ProductCart product) throws SQLException {
        Connection conn = null;
        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call addProductCart(?,?,?,?,?)}");
            pc.setLong(1, product.getIdCart());
            pc.setLong(2, product.getIdUser());
            pc.setLong(3, product.getIdProduct());
            pc.setInt(4, product.getQuantity());
            pc.setFloat(5, product.getTotalImport());
            pc.executeUpdate();
        } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }

    }

    public void changeQuiantityProductCart(final Long id, final ProductCart product) throws SQLException {
        Connection conn=null;
       try{ 
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call changeQuiantityProductCart(?,?,?,?)}");
        pc.setInt(1, product.getQuantity());
        pc.setLong(2, product.getIdProduct());
        pc.setLong(3, product.getIdCart());
        pc.setLong(4, product.getIdUser());
        pc.executeUpdate();
   } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }

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
        float cost = rs.getFloat(1);

        rs.close();
        return cost;
    }

    public void deleteCart(final Cart cart, final Long idUser) throws SQLException {
        Connection conn=null;
        try{
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call deleteCart(?,?)}");
        pc.setLong(1, cart.getIdCart());
        pc.setLong(2, idUser);
        pc.executeUpdate();
   } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }

    }
    public void deleteProductCat(final Long idCart, final Long idProd) throws SQLException {
        Connection conn=null;
        try{
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call deleteProductCart(?,?)}");
        pc.setLong(1, idProd);
        pc.setLong(2, idCart);
        pc.executeUpdate();
   } catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }

    }
    

    public List<Product> findrecomendedProduct(final Long idUser) throws SQLException {
        Connection conn=null;
        
        List<ProductCart> listProd = new ArrayList();
        List<Product> listprodRecomended = new ArrayList();
        
       
        try{
         conn = ConectionBD.getConnection();

            CallableStatement pc = null;
            pc = conn.prepareCall("{call findrecomendedProduct(?)}");
            pc.setLong(1, idUser);
            ResultSet rs = pc.executeQuery();
        while (rs.next()) {
            ProductCart product = new ProductCart();
            product.setIdProduct(rs.getLong("idProduct"));
            product.setNameProduct(rs.getString("nameProduct"));
            product.setCategory(rs.getString("category"));
            product.setPrice(rs.getFloat("price"));
            listProd.add(product);
        }
            System.out.println(listProd.size());
        LOGGER2.info("Product Recomennded");
        for (ProductCart obj : listProd) {
             Product prodRec = new Product();
            prodRec.setIdProduct(obj.getIdProduct());
            prodRec.setNameProduct(obj.getNameProduct());
            prodRec.setCategory(obj.getCategory());
            prodRec.setPrice(obj.getPrice());
            listprodRecomended.add(prodRec);
        }
       
        return listprodRecomended;
} catch (SQLException e) {
            LOGGER2.info("Error to execute Stored Procedure" + e);
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                System.out.println("SQL error : " + e);
            }

        }
         return listprodRecomended;
    }
}  
