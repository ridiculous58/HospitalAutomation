/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.DataAccess.IPersonalDal;
import com.hospitalautomation.Entities.Personal;
import java.util.List;

/**
 *
 * @author Monster
 */
public class PersonalManager implements IPersonalService{

    private IPersonalDal personalDal;

    public PersonalManager(IPersonalDal personalDal) {
        this.personalDal = personalDal;
    }
    
    @Override
    public List<Personal> getList() {
        return personalDal.getList();
    }

    @Override
    public void add(Personal personal) {
        personalDal.add(personal);
    }

    @Override
    public void update(Personal personal) {
        personalDal.update(personal);
    }

    @Override
    public void delete(int id) {
        Personal current_personal = personalDal.get(id);
        personalDal.delete(current_personal);
    }

    @Override
    public Personal getById(int id) {
        return personalDal.get(id);
    }

    @Override
    public Personal getByUserName(String userName) {
        return personalDal.getByUserName(userName);
    }

    @Override
    public Personal IsAuthenticated(String userName, String password) {
        Personal personal = personalDal.IsAuthenticated(userName, password);
        if (personal != null) {
            Thread.currentThread().setName(personal.getUserName());
        }
        return personal;
    }
    
}
