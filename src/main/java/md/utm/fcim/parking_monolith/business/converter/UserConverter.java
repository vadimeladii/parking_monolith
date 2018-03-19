package md.utm.fcim.parking_monolith.business.converter;

import md.utm.fcim.parking_monolith.business.dto.User;
import md.utm.fcim.parking_monolith.repository.entity.UserEntity;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

/**
 * Created by veladii on 03/18/2018
 */
@Component
public class UserConverter extends AbstractConverter<User, UserEntity> {

    private final RoleConverter roleConverter;

    public UserConverter(RoleConverter roleConverter) {
        super(User::new, UserEntity::new);
        this.roleConverter = roleConverter;
    }

    @Override
    protected UserEntity doForward(User dto) {
        UserEntity entity = super.doForward(dto);
        entity.setPassword(dto.getPassword());
        entity.setUsername(dto.getUsername());
        entity.setRoles(
                dto.getRoles()
                        .stream()
                        .map(roleConverter::convert)
                        .collect(Collectors.toSet())
        );
        return entity;
    }

    @Override
    protected User doBackward(UserEntity entity) {
        User dto = super.doBackward(entity);
        dto.setUsername(entity.getUsername());
        dto.setPassword(entity.getPassword());
        dto.setRoles(
                entity.getRoles()
                        .stream()
                        .map(roleConverter.reverse()::convert)
                        .collect(Collectors.toSet())
        );
        return dto;
    }
}
