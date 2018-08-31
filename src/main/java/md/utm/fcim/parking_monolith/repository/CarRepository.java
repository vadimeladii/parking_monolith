package md.utm.fcim.parking_monolith.repository;

import md.utm.fcim.parking_monolith.repository.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by veladii on 04/04/2018
 */
public interface CarRepository extends JpaRepository<CarEntity, Long> {
    Boolean existsByNumber(String number);
}
