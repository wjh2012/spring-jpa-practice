package practice.jpa.repository.Country;

import org.springframework.data.repository.CrudRepository;
import practice.jpa.entity.country.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
