/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hospitalautomation.skywalk.Business;

import hospitalautomation.Entities.City;
import hospitalautomation.skywalk.DataAccess.ICityDal;
import java.util.List;

/**
 *
 * @author Monster
 */
public class CityManager implements ICityService{

    private ICityDal cityDal;

    public CityManager(ICityDal cityDal) {
        this.cityDal = cityDal;
    }
    
    @Override
    public List<City> getList() {
        return cityDal.getList();
    }
    
}
