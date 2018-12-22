/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.service;

import com.globant.bootcamp.shoppingCartApi.conectionDB.ConectionBD;
import com.globant.bootcamp.shoppingCartApi.model.Product;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class ProductService {

    private final static Logger LOGGER = Logger.getLogger("ProductService");

    public List<Product> findAllProducts() throws SQLException {
        Connection conn = null;
        List<Product> listProd = new ArrayList();
        try {
            conn = ConectionBD.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("{call findAllProducts()}");

            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getLong("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getFloat("price"));
                listProd.add(product);
            }

            return listProd;
        } catch (SQLException e) {
            LOGGER.info("Error to execute Stored Procedure" + e);
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

    public Product findProductById(final Long id) throws SQLException {
        Connection conn = null;
        Product product = new Product();
        try {
            conn = ConectionBD.getConnection();

            CallableStatement pc = null;
            pc = conn.prepareCall("{call findProductById(?)}");
            pc.setLong(1, id);
            ResultSet rs = pc.executeQuery();

            while (rs.next()) {

                product.setIdProduct(rs.getLong("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getFloat("price"));

            }
        } catch (SQLException e) {
            LOGGER.info("Error to execute Stored Procedure" + e);
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

    public Product findProductByName(final String name) throws SQLException {
        Connection conn = null;
        Product product = new Product();
        try {
            conn = ConectionBD.getConnection();

            CallableStatement pc = null;
            pc = conn.prepareCall("{call findProductByName(?)}");
            pc.setString(1, name);
            ResultSet rs = pc.executeQuery();
            while (rs.next()) {

                product.setIdProduct(rs.getLong("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getFloat("price"));

            }
        } catch (SQLException e) {
            LOGGER.info("Error to execute Stored Procedure" + e);
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

    public List<Product> findProductsByCategory(final String category) throws SQLException {
        Connection conn = null;
        List<Product> listProd = new ArrayList();

        try {
            conn = ConectionBD.getConnection();

            CallableStatement pc = null;
            pc = conn.prepareCall("{call findProductByCategory(?)}");
            pc.setString(1, category);
            ResultSet rs = pc.executeQuery();
            while (rs.next()) {
                Product product = new Product();
                product.setIdProduct(rs.getLong("idProduct"));
                product.setNameProduct(rs.getString("nameProduct"));
                product.setCategory(rs.getString("category"));
                product.setPrice(rs.getFloat("price"));
                listProd.add(product);

            }
            return listProd;
        } catch (SQLException e) {
            LOGGER.info("Error to execute Stored Procedure" + e);
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

    public Product createProduct(final Product product) throws SQLException {
        Connection conn = null;

        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call createProduct(?,?,?,?)}");
            pc.setLong(1, product.getIdProduct());
            pc.setString(2, product.getNameProduct());
            pc.setString(3, product.getCategory());
            pc.setFloat(4, product.getPrice());
            pc.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error to execute Stored Procedure" + e);
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

    public Product updateProduct(final Product product) throws SQLException {
        Connection conn = null;

        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call updateProduct(?,?,?,?)}");
            pc.setLong(1, product.getIdProduct());
            pc.setString(2, product.getNameProduct());
            pc.setString(3, product.getCategory());
            pc.setFloat(4, product.getPrice());
            pc.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error to execute Stored Procedure" + e);
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

    public void deleteProduct(final Product product) throws SQLException {
        Connection conn = null;

        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call deleteProduct(?)}");
            pc.setFloat(1, product.getIdProduct());
            pc.executeUpdate();
        } catch (SQLException e) {
            LOGGER.info("Error to execute Stored Procedure" + e);
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

}
