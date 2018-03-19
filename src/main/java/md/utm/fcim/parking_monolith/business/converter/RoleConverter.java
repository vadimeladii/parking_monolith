package md.utm.fcim.parking_monolith.business.converter;

import md.utm.fcim.parking_monolith.business.dto.Role;
import md.utm.fcim.parking_monolith.repository.entity.RoleEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/18/2018
 */
@Component
public class RoleConverter extends AbstractConverter<Role, RoleEntity> {

    public RoleConverter() {
        super(Role::new, RoleEntity::new);
    }

    @Override
    protected RoleEntity doForward(Role dto) {
        RoleEntity entity = super.doForward(dto);
        entity.setType(dto.getType());
        return entity;
    }

    @Override
    protected Role doBackward(RoleEntity entity) {
        Role dto = super.doBackward(entity);
        dto.setType(entity.getType());
        return dto;
    }
}
