/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.globant.bootcamp.userApi.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Cristian
 */
@Entity
@Table(name = "user")
@ApiModel(value = "Info entity", description = "Complete data of a entity Info")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    @ApiModelProperty(value = "The id of the info", required = false)
    private Long idUser;
    @Column(name = "firstName")
    @ApiModelProperty(value = "The text of the info", required = true)
    private String firstName;
    @Column(name = "lastName")
    @ApiModelProperty(value = "The text of the info", required = true)
    private String lastName;
    @Column(name = "nickName")
    @ApiModelProperty(value = "The text of the info", required = true)
    private String nickName;
    @Column(name = "password")
    @ApiModelProperty(value = "The text of the info", required = true)
    private String password;

    public User() {

    }

    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
