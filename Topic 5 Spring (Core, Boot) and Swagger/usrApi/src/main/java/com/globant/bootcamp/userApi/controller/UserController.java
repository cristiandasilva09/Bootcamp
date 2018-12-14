/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.userApi.controller;

import com.globant.bootcamp.userApi.model.User;
import com.globant.bootcamp.userApi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Objects;
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

/**
 *
 * @author Cristian
 */
@RestController
@RequestMapping(
        path = "/user",
        produces = MediaType.APPLICATION_JSON_VALUE)
        @Api(value = "infos", description = "Infos API", produces = "application/json")
public class UserController {

    private final UserService service;

    public UserController(final UserService service) {
        this.service = service;
    }

    @GetMapping
    @ApiOperation(value = "Get Users", notes = "Returns all Users")
    @ApiResponses({
            @ApiResponse(code = 204, message = "No users registred"),@ApiResponse(code = 200, message = "Exits one user at least")
           
    })
    //  @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = service.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @GetMapping("/{idUser}")
    @ApiOperation(value = "Get User", notes = "Returns user by id")
    @ApiResponses({
            @ApiResponse(code = 404, message = "User id not found"),@ApiResponse(code = 200, message = "Return ok and the user")
           
    })
    public ResponseEntity<User> getUserById(@PathVariable("idUser") final Long id) {
        final User user = service.findUsernById(id);
        if (Objects.isNull(user)) {
            throw new UserFoundException("USER ID NOT FOUND: " + id);
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/userNick/{nickName}")
    @ApiOperation(value = "Get User by Nickname", notes = "Returns user by nickname")
    @ApiResponses({
            @ApiResponse(code = 404, message = "User  not found"),@ApiResponse(code = 200, message = "Return ok and the user")
           
    })
    public ResponseEntity<User> getUserByNickName(@PathVariable("nickName") final String nickName) {
        User user = service.findUserByNickName(nickName);
        if (Objects.isNull(user)) {
            throw new UserFoundException("USER  NOT FOUND: ");
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping("/userName/{firstName}")
     @ApiOperation(value = "Get User by FirstName", notes = "Returns user by firstname")
    @ApiResponses({
            @ApiResponse(code = 404, message = "User  not found"),@ApiResponse(code = 200, message = "Return ok and the user")
           
    })
    public ResponseEntity<User> getUserByName(@PathVariable("firstName") final String firstName) {
        User user = service.findUserByName(firstName);
        if (Objects.isNull(user)) {
            throw new UserFoundException("USER  NOT FOUND: ");
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @PostMapping("/{idUser}")
    @ApiOperation(value = "Post user", notes = "Create user")
    @ApiResponses({
            @ApiResponse(code = 409, message = "User id already exist"), @ApiResponse(code = 409, message = "User nickname already exist")
            ,@ApiResponse(code = 200, message = "Return ok and the user")
           
    })
    public ResponseEntity<User> postUser(@RequestBody final User user) {
        List<User> users = service.findAllUsers();
        for (User obj : users) {
            if (obj.getIdUser() == user.getIdUser()) {
                throw new UserExistException("USER ID ALREADY EXIST: " + user.getIdUser());
            }
            if (obj.getNickName().equals(user.getNickName())) {
                throw new UserExistException("USER NICKNAME ALREADY EXIST: " + user.getNickName());
            }
        }

        service.createUser(user);
        return new ResponseEntity<User>(user, HttpStatus.CREATED);
    }

    @PutMapping("/{idUser}")
    @ApiOperation(value = "Put user", notes = "Modify user by id")
    @ApiResponses({
            @ApiResponse(code = 404, message = "User not found")
           ,@ApiResponse(code = 200, message = "Return ok and the user modify")
           
    })
    public ResponseEntity<User> putUser(@PathVariable(name = "idUser") final Long id,
            @RequestBody final User user) {

        User users = service.updateUser(user);
        if (Objects.isNull(user)) {
            throw new UserFoundException("USER  NOT FOUND: ");
        }
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }
    
    @DeleteMapping("/{idUser}")
     @ApiOperation(value = "Delete user", notes = "Delete user by id")
    @ApiResponses({
            @ApiResponse(code = 404, message = "User not found")
           ,@ApiResponse(code = 200, message = "Return ok and the user modify")
           
    })
    public ResponseEntity<User> deleteUser(@PathVariable(name = "idUser") final Long id) {
        User user = service.findUsernById(id);
        if (Objects.isNull(user)) {
            throw new UserFoundException("USER NOT FOUND: " + id);
        }
        service.deleteUser(user);
        return new ResponseEntity<User>(user, HttpStatus.OK);

    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class UserFoundException extends RuntimeException {

        public UserFoundException(String message) {
            super(message);
        }
    }

    @ResponseStatus(HttpStatus.CONFLICT)
    public static class UserExistException extends RuntimeException {

        public UserExistException(String message) {
            super(message);
        }
    }
}
