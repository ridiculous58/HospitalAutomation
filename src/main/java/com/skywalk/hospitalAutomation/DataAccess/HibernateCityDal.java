/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.skywalk.hospitalAutomation.DataAccess;

import com.skywalk.hospitalAutomation.Core.HibernateEntityRepositoryBase;
import com.skywalk.hospitalAutomation.Core.IEntityRepository;
import com.skywalk.hospitalAutomation.Entities.City;
import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Monster
 */
@Repository
public class HibernateCityDal extends HibernateEntityRepositoryBase<City>  implements ICityDal{

    @Autowired
    public HibernateCityDal(EntityManager entityManager) {
        super(entityManager,City.class);
    }

    
    
}
