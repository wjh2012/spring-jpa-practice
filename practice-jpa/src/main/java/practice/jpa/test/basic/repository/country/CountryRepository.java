package practice.jpa.test.basic.repository.country;

import org.springframework.data.repository.CrudRepository;
import practice.jpa.test.basic.entity.country.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
