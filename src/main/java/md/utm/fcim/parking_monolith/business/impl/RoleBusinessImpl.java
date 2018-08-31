package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.RoleBusiness;
import md.utm.fcim.parking_monolith.business.converter.RoleConverter;
import md.utm.fcim.parking_monolith.business.dto.Role;
import md.utm.fcim.parking_monolith.business.enums.RoleType;
import md.utm.fcim.parking_monolith.repository.RoleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by veladii on 03/23/2018
 */
@Service
@RequiredArgsConstructor
public class RoleBusinessImpl implements RoleBusiness {

    private final RoleRepository repository;
    private final RoleConverter converter;

    public Optional<Role> retrieveByType(RoleType type) {
        return Optional.ofNullable(converter.reverse().convert(repository.findByType(type.name())));
    }
}
