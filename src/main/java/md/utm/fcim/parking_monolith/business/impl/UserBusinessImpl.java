package md.utm.fcim.parking_monolith.business.impl;

import com.google.common.collect.Sets;
import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.RoleBusiness;
import md.utm.fcim.parking_monolith.business.UserBusiness;
import md.utm.fcim.parking_monolith.business.converter.UserConverter;
import md.utm.fcim.parking_monolith.business.dto.Role;
import md.utm.fcim.parking_monolith.business.dto.Token;
import md.utm.fcim.parking_monolith.business.dto.User;
import md.utm.fcim.parking_monolith.business.enums.RoleType;
import md.utm.fcim.parking_monolith.repository.UserRepository;
import md.utm.fcim.parking_monolith.webservice.view.UserSimpleView;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by veladii on 03/18/2018
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserBusinessImpl implements UserBusiness {

    private final UserRepository repository;
    private final UserConverter converter;
    private final TokenHandler tokenHandler;
    private final RoleBusiness roleBusiness;

    @Override
    public Optional<User> findByUsername(String username) {
        return repository.findByUsername(username).map(converter.reverse()::convert);
    }

    public Optional<Token> login(UserSimpleView view) {
        return repository.findByUsername(view.getUsername())
                .flatMap(userEntity -> tokenHandler.generateAccessToken(
                        userEntity.getUsername(),
                        LocalDateTime.now().plus(Duration.ofHours(4))
                ))
                .map(Token::new);
    }

    @Override
    @Transactional
    public User create(User dto) {
        return converter.reverse().convert(repository.save(converter.convert(buildDto(dto))));
    }

    @Override
    public List<User> retrieve() {
        return repository.findAll()
                .stream()
                .map(converter.reverse()::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> retrieveById(Long id) {
        return repository.findById(id).map(converter.reverse()::convert);
    }

    private User buildDto(User dto) {
        dto.setRoles(Sets.newHashSet((roleBusiness.retrieveByType(RoleType.SIMPLE).orElse(new Role(RoleType.SIMPLE.name())))));
        dto.setBalance(BigDecimal.ZERO);
        return dto;
    }
}
