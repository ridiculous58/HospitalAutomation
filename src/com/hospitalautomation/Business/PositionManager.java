/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.DataAccess.IPositionDal;
import com.hospitalautomation.Entities.Position;
import java.util.List;

/**
 *
 * @author Monster
 */
public class PositionManager implements IPositionService{

    private IPositionDal positionDal;

    public PositionManager(IPositionDal positionDal) {
        this.positionDal = positionDal;
    }

    @Override
    public List<Position> getList() {
        return positionDal.getList();
    }

    @Override
    public void add(Position position) {
        positionDal.add(position);
    }

    @Override
    public void update(Position position) {
        positionDal.update(position);
    }

    @Override
    public void delete(int id) {
        Position current_position = positionDal.get(id);
        positionDal.delete(current_position);
    }

    @Override
    public Position getById(int id) {
       return positionDal.get(id);
    }
    
}
