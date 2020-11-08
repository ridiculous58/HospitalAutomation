package com.skywalk.hospitalAutomation.restApi;

import com.skywalk.hospitalAutomation.Business.ICityService;
import com.skywalk.hospitalAutomation.Entities.City;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class CitiesController {
    private ICityService cityService;
    @Autowired
    public CitiesController(ICityService cityService) {
        this.cityService = cityService;
    }
    @GetMapping("/cities")
    public List<City> get()
    {
        return cityService.getAll();
    }
    
}
