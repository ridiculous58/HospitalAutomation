/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalautomation.UI;

import hospitalautomation.Entities.City;
import hospitalautomation.skywalk.Business.*;
import hospitalautomation.skywalk.DataAccess.HibernateCityDal;
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
