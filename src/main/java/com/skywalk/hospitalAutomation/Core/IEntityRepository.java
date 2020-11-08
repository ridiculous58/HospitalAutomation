/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skywalk.hospitalAutomation.Core;

import java.util.List;

/**
 *
 * @author Monster
 */
public interface IEntityRepository<T> {
    List<T> getAll();
    void add(T entity);
    void update(T entity);
    void delete(T entity);
}
