/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.UI;

import com.hospitalautomation.Business.ICityService;
import com.hospitalautomation.Business.CityManager;
import com.hospitalautomation.Entities.City;
import com.hospitalautomation.DataAccess.HibernateCityDal;
import java.util.List;

/**
 *
 * @author Monster
 */
public class HospitalAutomation {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ICityService cityService = new CityManager(new HibernateCityDal());
        
        List<City> cities = cityService.getList();
        for (City city :cities ) {
            System.out.println(city.getName());
        }
    }
    
}
