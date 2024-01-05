package practice.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.entity.country.City;
import practice.entity.country.Country;
import practice.entity.country.District;
import practice.entity.country.Town;
import practice.repository.Country.CityRepository;
import practice.repository.Country.CountryRepository;
import practice.repository.Country.DistrictRepository;
import practice.repository.Country.TownRepository;

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
