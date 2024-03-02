package practice.jpa.repository.Country;

import org.springframework.data.repository.CrudRepository;
import practice.jpa.entity.country.Town;

public interface TownRepository extends CrudRepository<Town, Long> {

}
