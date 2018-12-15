/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.userApi.repository;

import com.globant.bootcamp.userApi.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Cristian
 */
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();
}
