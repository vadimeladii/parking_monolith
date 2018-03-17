package md.utm.fcim.parking_monolith.repository;

import md.utm.fcim.parking_monolith.repository.entity.ParkingLotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParkinLotRepository extends JpaRepository<ParkingLotEntity, Long> {
}
