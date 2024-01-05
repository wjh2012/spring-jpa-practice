package practice.repository.Country;

import org.springframework.data.repository.CrudRepository;
import practice.entity.country.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
