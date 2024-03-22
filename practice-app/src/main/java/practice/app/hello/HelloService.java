package practice.app.hello;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.jpa.basic.entity.country.Country;
import practice.jpa.basic.service.CountryService;

@Service
public class HelloService {

    @Autowired
    private CountryService countryService;
    public void hi(){
        Country country = new Country();
        countryService.saveCountry(country);
    }

}
