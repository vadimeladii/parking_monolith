package md.utm.fcim.parking_monolith.repository;

import md.utm.fcim.parking_monolith.repository.entity.NotificationEntity;
import md.utm.fcim.parking_monolith.repository.entity.ParkingLotEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.stream.Stream;

/**
 * Created by veladii on 03/24/2018
 */
public interface NotificationRepository extends JpaRepository<NotificationEntity, Long> {
    Stream<NotificationEntity> findByParkingLotEntity(ParkingLotEntity entity);
}
