package practice.repository.Country;

import org.springframework.data.repository.CrudRepository;
import practice.entity.country.Town;

public interface TownRepository extends CrudRepository<Town, Long> {

}
