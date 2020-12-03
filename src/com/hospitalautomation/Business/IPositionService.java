/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.Entities.Personal;
import com.hospitalautomation.Entities.Position;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface IPositionService {
   List<Position> getList(); 
   Position getById(int id);
   void add(Position personal);
   void update(Position personal);
   void delete(int id);
}
