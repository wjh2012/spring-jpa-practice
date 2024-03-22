package practice.app.hello;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jpa.basic.entity.country.Country;
import practice.jpa.basic.service.CountryService;

@Service
@RequiredArgsConstructor
public class HelloService {

    private final CountryService countryService;

    public void hi() {
        Country country = new Country();
        countryService.saveCountry(country);
    }

}
