
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.City;
import com.hospitalautomation.Infrastructure.HibernateEntityRepositoryBase;
import org.hibernate.SessionFactory;

public class HibernateCityDal extends HibernateEntityRepositoryBase<City> implements ICityDal{
    public HibernateCityDal() {
        super(City.class);
    }
    
}
