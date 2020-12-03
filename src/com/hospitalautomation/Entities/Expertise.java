/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Entities;

import com.hospitalautomation.Infrastructure.IEntity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Monster
 */
@Entity
@Table(name = "Expertises")
public class Expertise implements IEntity{
    @Id
    @Column(name = "Id")
    private int id;
    @Column(name = "name")
    private String name;
    
    public Expertise() {
    }

    public Expertise(String name) {
        this.name = name;
    }

    public Expertise(int id, String name) {
        this.id = id;
        this.name = name;
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
    
    
    
}
