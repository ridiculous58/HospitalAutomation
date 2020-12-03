/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.hospitalautomation.Business;

import com.hospitalautomation.Entities.Personal;
import java.util.List;

/**
 *
 * @author Monster
 */
public interface IPersonalService {
   List<Personal> getList(); 
   void add(Personal personal);
   void update(Personal personal);
   void delete(int id);
}
