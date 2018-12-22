/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.service;

import com.globant.bootcamp.shoppingCartApi.conectionDB.ConectionBD;
import com.globant.bootcamp.shoppingCartApi.model.User;
import com.globant.bootcamp.shoppingCartApi.repository.UserRepository;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class UserService {

    private final UserRepository repository;
    private final static Logger LOGGER = Logger.getLogger("UserService");

    @Autowired
    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUsers() throws SQLException {
        Connection conn = null;
        List<User> listUser = new ArrayList();
        try {
            conn = ConectionBD.getConnection();
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("{call findAllUsers()}");

            while (rs.next()) {
                User user = new User();
                user.setIdUser(rs.getLong("idUser"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setNickName(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getFloat("money"));
                listUser.add(user);
            }
            return listUser;
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
        return listUser;
    }

    public User findUsernById(final Long id) throws SQLException {
        Connection conn = null;
        User user = new User();

        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call findUserById(?)}");
            pc.setLong(1, id);
            ResultSet rs = pc.executeQuery();
            while (rs.next()) {

                user.setIdUser(rs.getLong("idUser"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setNickName(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getFloat("money"));
            }
            
            return user;
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
         
        return user;
    }

    public User findUserByName(final String firstName) throws SQLException {
        Connection conn = null;
        User user = new User();
        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call findUserByName(?)}");
            pc.setString(1, firstName);
            ResultSet rs = pc.executeQuery();

            while (rs.next()) {

                user.setIdUser(rs.getLong("idUser"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setNickName(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getFloat("money"));
            }
            System.out.println(user.getMoney());
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
        return user;
    }

    public User findUserByNickName(final String nickName) throws SQLException {
        Connection conn = null;
        User user = new User();
        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call findUserByNickName(?)}");
            pc.setString(1, nickName);
            ResultSet rs = pc.executeQuery();

            while (rs.next()) {

                user.setIdUser(rs.getLong("idUser"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setNickName(rs.getString("nickname"));
                user.setPassword(rs.getString("password"));
                user.setMoney(rs.getFloat("money"));
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
        return user;
    }

    public User createUser(final User user) throws SQLException {
        Connection conn = null;

        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call createUser(?,?,?,?,?,?)}");
            pc.setLong(1, user.getIdUser());
            pc.setString(2, user.getFirstName());
            pc.setString(3, user.getLastName());
            pc.setString(4, user.getNickName());
            pc.setString(5, user.getPassword());
            pc.setFloat(6, user.getMoney());
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
        return user;
    }

    public User updateUser(final User user) throws SQLException {
        Connection conn = null;

        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call updateUser(?,?,?,?,?,?)}");
            pc.setLong(1, user.getIdUser());
            pc.setString(2, user.getFirstName());
            pc.setString(3, user.getLastName());
            pc.setString(4, user.getNickName());
            pc.setString(5, user.getPassword());
            pc.setFloat(6, user.getMoney());

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
        return user;
    }

    public void updateUserMoney(final float money, final Long id) throws SQLException {
          Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("update user set money=? where idUser=?");
        pConsulta.setFloat(1,money);
        pConsulta.setLong(2, id);
        pConsulta.executeUpdate();
       conn.close();
    }
    public void deleteUser(final User user) throws SQLException {
        Connection conn = null;

        try {
            conn = ConectionBD.getConnection();
            CallableStatement pc = null;
            pc = conn.prepareCall("{call deleteUser(?)}");
            pc.setFloat(1, user.getIdUser());
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
