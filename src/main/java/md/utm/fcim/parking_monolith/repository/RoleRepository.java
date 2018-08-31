package md.utm.fcim.parking_monolith.repository;

import md.utm.fcim.parking_monolith.repository.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by veladii on 03/23/2018
 */
public interface RoleRepository extends JpaRepository<RoleEntity, Long> {
    RoleEntity findByType(String type);
}
