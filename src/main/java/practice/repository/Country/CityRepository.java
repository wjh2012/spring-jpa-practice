package practice.repository.Country;

import org.springframework.data.repository.CrudRepository;
import practice.entity.City;

public interface CityRepository extends CrudRepository<City, Long> {

}
