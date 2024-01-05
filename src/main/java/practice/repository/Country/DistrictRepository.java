package practice.repository.Country;

import org.springframework.data.repository.CrudRepository;
import practice.entity.country.District;

public interface DistrictRepository extends CrudRepository<District, Long> {

}
