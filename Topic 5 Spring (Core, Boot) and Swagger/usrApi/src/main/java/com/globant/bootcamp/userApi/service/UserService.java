/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.userApi.service;


import com.globant.bootcamp.userApi.model.User;
import com.globant.bootcamp.userApi.repository.UserRepository;
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

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User findUsernById(final Long id) {
        return repository.findById(id)
                .orElse(null);
    }

    public User findUserByName(final String firstName) {
        List<User> listUser = repository.findAll();
        for (User obj:listUser) {
            if (obj.getFirstName().equals(firstName)) {
                return obj;
            }
        }
        return null;
    }

    public User findUserByNickName(final String nickName) {
        List<User> listUser = repository.findAll();
       for (User obj:listUser) {
            if (obj.getNickName().equals(nickName)) {
                return obj;
            }
        }
        return null;
    }

    public User createUser(final User user) {
      
        user.setIdUser(null);
        return repository.save(user);
    }

    public User updateUser(final User user) {
         List<User> listUser = repository.findAll();
         for(User obj:listUser){
             if(obj.getIdUser()==user.getIdUser()){
                obj.setFirstName(user.getFirstName());
                obj.setLastName(user.getLastName());
                obj.setNickName(user.getNickName());
                obj.setPassword(user.getPassword());
                return repository.save(obj);
             }
         }
         return null;
          /*   final User original = findUsernById(user.getIdUser());
        if (Objects.isNull(original)) {
            return null;
        }
        return repository.save(user);*/
    }  
    
    

     public void deleteUser(final User user) {
     //   final User original = findUsernById(user.getIdUser());
         repository.delete(user);
    }

}
