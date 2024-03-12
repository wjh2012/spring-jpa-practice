package practice;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import practice.jpa.entity.country.City;
import practice.jpa.entity.country.Country;
import practice.jpa.entity.country.District;
import practice.jpa.entity.country.Town;
import practice.jpa.entity.uuid.UUIDMember;
import practice.jpa.repository.UUIDMember.UUIDMemberRepository;
import practice.jpa.service.CountryService;

@Component
@RequiredArgsConstructor
public class DBInit {

    private final CountryService countryService;
    private final UUIDMemberRepository UUIDMemberRepository;

    @PostConstruct
    public void init() {
        saveSampleData();
    }

    private void saveSampleData() {

        List<Town> towns = new ArrayList<>();
        List<District> districts = new ArrayList<>();
        List<City> cities = new ArrayList<>();

        for(int i=0; i<84; i++){
            Town t = new Town();
            t.setName("Town"+(i+1));
            towns.add(t);
            countryService.saveTown(t);
        }

        for(int i=0; i<27; i++){
            District t = new District();
            t.setName("District"+(i+1));
            t.setTowns(towns.subList(i*3,i*3+3));
            districts.add(t);
            countryService.saveDistrict(t);
        }

        for(int i=0; i<9; i++){
            City t = new City();
            t.setName("City"+(i+1));
            t.setDistricts(districts.subList(i*3,i*3+3));
            cities.add(t);
            countryService.saveCity(t);
        }

        for(int i=0; i<3; i++){
            Country t = new Country();
            t.setName("Country"+(i+1));
            t.setCities(cities.subList(i*3,i*3+3));
            countryService.saveCountry(t);
        }

        UUIDMember UUIDMember = new UUIDMember();
        UUIDMemberRepository.save(UUIDMember);
    }
}
