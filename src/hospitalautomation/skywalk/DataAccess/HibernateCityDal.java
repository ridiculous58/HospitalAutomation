
package hospitalautomation.skywalk.DataAccess;

import hospitalautomation.Entities.City;
import hospitalautomation.Infrastructure.HibernateEntityRepositoryBase;
import org.hibernate.SessionFactory;

public class HibernateCityDal extends HibernateEntityRepositoryBase<City> implements ICityDal{
    public HibernateCityDal() {
        super(City.class);
    }
    
}
