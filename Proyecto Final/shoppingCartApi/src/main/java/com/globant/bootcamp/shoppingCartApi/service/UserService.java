/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.shoppingCartApi.service;

import com.globant.bootcamp.shoppingCartApi.conectionDB.ConectionBD;
import com.globant.bootcamp.shoppingCartApi.model.User;
import com.globant.bootcamp.shoppingCartApi.repository.UserRepository;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Cristian
 */
@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(final UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUsers() throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user");
        List<User> listUser = new ArrayList();
        while (rs.next()) {
            User user = new User();
            user.setIdUser(rs.getLong("idUser"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setNickName(rs.getString("nickname"));
            user.setPassword(rs.getString("password"));
            user.setMonto(rs.getFloat("monto"));
            listUser.add(user);
        }
        rs.close();
        return listUser;
    }

    public User findUsernById(final Long id) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user where idUser=" + id + "");
        User user = new User();
        while (rs.next()) {

            user.setIdUser(rs.getLong("idUser"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setNickName(rs.getString("nickname"));
            user.setPassword(rs.getString("password"));
            user.setMonto(rs.getFloat("monto"));
        }
        rs.close();
        //conn.close();
        return user;
    }

    public User findUserByName(final String firstName) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user where  firstName='" + firstName + "'");
        User user = new User();
        while (rs.next()) {

            user.setIdUser(rs.getLong("idUser"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setNickName(rs.getString("nickname"));
            user.setPassword(rs.getString("password"));
            user.setMonto(rs.getFloat("monto"));
        }
        rs.close();
        return user;
    }

    public User findUserByNickName(final String nickName) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        Statement st = conn.createStatement();
        ResultSet rs = st.executeQuery("select * from user where nickName='" + nickName + "'");
        User user = new User();
        while (rs.next()) {

            user.setIdUser(rs.getLong("idUser"));
            user.setFirstName(rs.getString("firstName"));
            user.setLastName(rs.getString("lastName"));
            user.setNickName(rs.getString("nickname"));
            user.setPassword(rs.getString("password"));
            user.setMonto(rs.getFloat("monto"));
        }
        rs.close();
        return user;
    }

    public User createUser(final User user) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("insert into user values(?, ?, ?, ?, ?,?)");
        pConsulta.setLong(1, user.getIdUser());
        pConsulta.setString(2, user.getFirstName());
        pConsulta.setString(3, user.getLastName());
        pConsulta.setString(4, user.getNickName());
        pConsulta.setString(5, user.getPassword());
        pConsulta.setFloat(6, user.getMonto());
        pConsulta.executeUpdate();
        return user;
    }

    public User updateUser(final User user) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("update user set firstName=?,lastName=?,nickname=?,password=?,monto=? where idUser=?");

        //pConsulta.setLong(1, user.getIdUser());
        pConsulta.setString(1, user.getFirstName());
        pConsulta.setString(2, user.getLastName());
        pConsulta.setString(3, user.getNickName());
        pConsulta.setString(4, user.getPassword());
        pConsulta.setFloat(5, user.getMonto());
        pConsulta.setLong(6, user.getIdUser());
        pConsulta.executeUpdate();
        return user;
    }
    
    public User updateUserMoney(final float monto,final User user) throws SQLException {
        Connection conn;
        conn = ConectionBD.getConnection();
        PreparedStatement pConsulta = conn.prepareStatement("update user set monto=? where idUser=?");
        pConsulta.setFloat(1,monto);
        pConsulta.setLong(2, user.getIdUser());
        pConsulta.executeUpdate();
        return user;
    }

    public void deleteUser(final User user) throws SQLException {
        Connection conn;

        conn = ConectionBD.getConnection();

        PreparedStatement pConsulta = conn.prepareStatement("delete from user where idUser=" + user.getIdUser() + "");
        pConsulta.executeUpdate();
    }

}
