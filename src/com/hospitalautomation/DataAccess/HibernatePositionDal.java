/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.Position;
import com.hospitalautomation.Infrastructure.HibernateEntityRepositoryBase;

/**
 *
 * @author Monster
 */
public class HibernatePositionDal extends HibernateEntityRepositoryBase<Position> implements IPositionDal{

    public HibernatePositionDal() {
        super(Position.class);
    }
    
}
