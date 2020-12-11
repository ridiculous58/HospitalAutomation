
package com.hospitalautomation.DataAccess;

import com.hospitalautomation.Entities.Doctor;
import com.hospitalautomation.Entities.Expertise;
import com.hospitalautomation.Infrastructure.IEntityRepository;


public interface IDoctorDal extends IEntityRepository<Doctor> {
    public Doctor IsAuthenticated(String userName,String password);

    public Doctor getByUserName(String userName);
}
