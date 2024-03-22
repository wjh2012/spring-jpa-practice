package practiceJPA.basic.service;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practiceJPA.basic.entity.country.City;
import practiceJPA.basic.entity.country.Country;
import practiceJPA.basic.entity.country.District;
import practiceJPA.basic.entity.country.Town;
import practiceJPA.basic.repository.country.CityRepository;
import practiceJPA.basic.repository.country.CountryRepository;
import practiceJPA.basic.repository.country.DistrictRepository;
import practiceJPA.basic.repository.country.TownRepository;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CityRepository cityRepository;
    private final DistrictRepository districtRepository;
    private final TownRepository townRepository;

    public void saveCountry(Country country) {
        countryRepository.save(country);
    }

    public void saveCity(City city) {
        cityRepository.save(city);
    }

    public void saveDistrict(District district) {
        districtRepository.save(district);
    }

    public void saveTown(Town town) {
        townRepository.save(town);
    }
}
