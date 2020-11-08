/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skywalk.hospitalAutomation.Business;

import com.skywalk.hospitalAutomation.Entities.City;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface ICityService {
    List<City> getAll();
    void add(City entity);
    void update(City entity);
    void delete(City entity);
}
