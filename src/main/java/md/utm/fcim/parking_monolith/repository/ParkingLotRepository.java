package md.utm.fcim.parking_monolith.repository;

import md.utm.fcim.parking_monolith.repository.entity.ParkingLotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by veladii on 03/17/2018
 */
public interface ParkingLotRepository extends JpaRepository<ParkingLotEntity, Long> {
}
