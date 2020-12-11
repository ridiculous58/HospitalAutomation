/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.Personal;
import com.hospitalautomation.Infrastructure.IEntityRepository;

/**
 *
 * @author Monster
 */
public interface IPersonalDal extends IEntityRepository<Personal> {

    public Personal IsAuthenticated(String userName,String password);
    public Personal getByUserName(String userName);
    
}
