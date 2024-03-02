package practice.jpa.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import practice.jpa.entity.country.City;
import practice.jpa.entity.country.Country;
import practice.jpa.entity.country.District;
import practice.jpa.entity.country.Town;
import practice.jpa.repository.Country.CityRepository;
import practice.jpa.repository.Country.CountryRepository;
import practice.jpa.repository.Country.DistrictRepository;
import practice.jpa.repository.Country.TownRepository;

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
