package practice.jpa.test.basic.repository.country;

import org.springframework.data.repository.CrudRepository;
import practice.jpa.test.basic.entity.country.District;

public interface DistrictRepository extends CrudRepository<District, Long> {

}
