package practice.jpa.test.basic.repository.country;


import org.springframework.data.repository.CrudRepository;
import practice.jpa.test.basic.entity.country.City;

public interface CityRepository extends CrudRepository<City, Long> {

}
