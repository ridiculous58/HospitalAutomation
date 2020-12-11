/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Entities;

import com.hospitalautomation.Infrastructure.IEntity;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Monster
 */
@Entity
@Table(name = "Patients")
public class Patient implements IEntity{
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "birthdate")
    private LocalDateTime birthdate;
    @Column(name = "UserName")
    private String userName;
    @Column(name = "Password")
    private String password;
    

    public Patient() {
    }

    public Patient(String name, String surname, LocalDateTime birthdate, String userName, String password) {
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.userName = userName;
        this.password = password;
    }

    public Patient(int id, String name, String surname, LocalDateTime birthdate, String userName, String password) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.userName = userName;
        this.password = password;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDateTime getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDateTime birthdate) {
        this.birthdate = birthdate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
