package md.utm.fcim.parking_monolith.repository;

import md.utm.fcim.parking_monolith.repository.entity.CameraEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by veladii on 04/01/2018
 */
public interface CameraRepository extends JpaRepository<CameraEntity, Long> {
}
