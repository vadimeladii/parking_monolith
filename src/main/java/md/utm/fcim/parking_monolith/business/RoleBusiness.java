package md.utm.fcim.parking_monolith.business;

import md.utm.fcim.parking_monolith.business.dto.Role;
import md.utm.fcim.parking_monolith.business.enums.RoleType;

import java.util.Optional;

/**
 * Created by veladii on 03/23/2018
 */
public interface RoleBusiness {

    Optional<Role> retrieveByType(RoleType type);
}
