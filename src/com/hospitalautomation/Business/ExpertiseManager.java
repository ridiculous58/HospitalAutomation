/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.DataAccess.IExpertiseDal;
import com.hospitalautomation.Entities.Expertise;
import java.util.List;

/**
 *
 * @author Monster
 */
public class ExpertiseManager implements IExpertiseService{

    private IExpertiseDal expertiseDal;

    public ExpertiseManager(IExpertiseDal expertiseDal) {
        this.expertiseDal = expertiseDal;
    }
    
    @Override
    public List<Expertise> getList() {
       return expertiseDal.getList();
    }

    @Override
    public Expertise getById(int id) {
       return expertiseDal.get(id);
    }

    @Override
    public void add(Expertise expertise) {
        expertiseDal.add(expertise);
    }

    @Override
    public void update(Expertise expertise) {
        expertiseDal.update(expertise);
    }

    @Override
    public void delete(int id) {
        Expertise current_expertise = expertiseDal.get(id);
        expertiseDal.delete(current_expertise);
    }
    
}
