package practiceJPA.basic.repository.country;

import org.springframework.data.repository.CrudRepository;
import practiceJPA.basic.entity.country.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
