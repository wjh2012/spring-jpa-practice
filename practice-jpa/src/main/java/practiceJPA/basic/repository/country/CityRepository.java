package practiceJPA.basic.repository.country;


import org.springframework.data.repository.CrudRepository;
import practiceJPA.basic.entity.country.City;

public interface CityRepository extends CrudRepository<City, Long> {

}
