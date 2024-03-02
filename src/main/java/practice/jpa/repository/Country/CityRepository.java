package practice.jpa.repository.Country;

import org.springframework.data.repository.CrudRepository;
import practice.jpa.entity.country.City;

public interface CityRepository extends CrudRepository<City, Long> {

}
