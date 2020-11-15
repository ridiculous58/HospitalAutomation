
package com.hospitalautomation.Business;

import com.hospitalautomation.DataAccess.HibernateCityDal;
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
    public ICityDal database(){
        return new HibernateCityDal();
    }
    @Bean
    public ICityService service(){
        return new CityManager(database());
    }
}
