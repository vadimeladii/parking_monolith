package md.utm.fcim.parking_monolith.business.converter;

import com.google.common.base.Converter;
import md.utm.fcim.parking_monolith.business.dto.Role;
import md.utm.fcim.parking_monolith.repository.entity.RoleEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/18/2018
 */
@Component
public class RoleConverter extends Converter<Role, RoleEntity> {

    @Override
    protected RoleEntity doForward(Role dto) {
        RoleEntity entity = new RoleEntity();
        entity.setIdRole(dto.getIdRole());
        entity.setType(dto.getType());
        return entity;
    }

    @Override
    protected Role doBackward(RoleEntity entity) {
        Role dto = new Role();
        dto.setIdRole(entity.getIdRole());
        dto.setType(entity.getType());
        return dto;
    }
}
