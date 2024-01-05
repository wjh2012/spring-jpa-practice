package practice.repository.Country;

import org.springframework.data.repository.CrudRepository;
import practice.entity.Country;

public interface CountryRepository extends CrudRepository<Country, Long> {

}
