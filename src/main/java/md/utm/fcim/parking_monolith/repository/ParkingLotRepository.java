package md.utm.fcim.parking_monolith.repository;

import md.utm.fcim.parking_monolith.repository.entity.ParkingLotEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by veladii on 03/17/2018
 */
public interface ParkingLotRepository extends JpaRepository<ParkingLotEntity, Long> {

    @Modifying
    @Query(value = "UPDATE ParkingLotEntity p SET p.availablePlaces = (p.availablePlaces + 1) WHERE p.id = :id and p.availablePlaces < p.totalPlaces")
    void increment(@Param("id") Long id);

    @Modifying
    @Query(value = "UPDATE ParkingLotEntity p SET p.availablePlaces = (p.availablePlaces - 1) WHERE p.id = :id and p.availablePlaces > 0")
    void decrement(@Param("id") Long id);
}
