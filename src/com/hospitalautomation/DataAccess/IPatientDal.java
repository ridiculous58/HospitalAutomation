/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.Patient;
import com.hospitalautomation.Infrastructure.IEntityRepository;

/**
 *
 * @author Monster
 */
public interface IPatientDal extends IEntityRepository<Patient>{

    public Patient getByUserNameAndPassword(String userName, String password);

    public Patient getByUserName(String userName);
    
}
