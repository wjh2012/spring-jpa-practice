package practice.jpa.repository.country;

import org.springframework.data.repository.CrudRepository;
import practice.jpa.entity.country.City;

public interface CityRepository extends CrudRepository<City, Long> {

}
