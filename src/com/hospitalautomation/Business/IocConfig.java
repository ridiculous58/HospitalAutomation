
package com.hospitalautomation.Business;


import com.hospitalautomation.DataAccess.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan("com.hospitalAutomation")
//@PropertySource("classpath:values.properties")
public class IocConfig {
    @Bean
    public IDoctorDal doctorDal(){
        return new HibernateDoctorDal();
    }
    @Bean
    public IDoctorService doctorService(){
        return new DoctorManager(doctorDal());
    }
    @Bean
    public IPersonalDal personalDal(){
        return new HibernatePersonalDal();
    }
    @Bean
    public IPersonalService personalService(){
        return new PersonalManager(personalDal());
    }
    
    @Bean
    public IPositionDal postionDal(){
        return new HibernatePositionDal();
    }
    @Bean
    public IPositionService positionService(){
        return new PositionManager(postionDal());
    }
    @Bean
    public IExpertiseDal expertiseDal(){
        return new HibernateExpertiseDal();
    }
    @Bean
    public IExpertiseService expertiseService(){
        return new ExpertiseManager(expertiseDal());
    }
    @Bean
    public IPatientDal patientDal(){
        return new HibernatePatientDal();
    }
    @Bean
    public IPatientService patientService(){
        return new PatientManager(patientDal());
    }
    @Bean
    public IPatientAppointmentDal patientAppointmentDal(){
        return new HibernatePatientAppointmentDal();
    }
    @Bean
    public IPatientAppointmentService patientAppointmentService(){
        return new PatientAppointmentManager(patientAppointmentDal());
    }
    
}
