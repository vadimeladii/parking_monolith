package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.UserBusiness;
import md.utm.fcim.parking_monolith.business.converter.UserConverter;
import md.utm.fcim.parking_monolith.business.dto.Token;
import md.utm.fcim.parking_monolith.business.dto.User;
import md.utm.fcim.parking_monolith.repository.UserRepository;
import md.utm.fcim.parking_monolith.webservice.view.UserSimpleView;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Optional;

/**
 * Created by veladii on 03/18/2018
 */
@Service
@RequiredArgsConstructor
public class UserBusinessImpl implements UserBusiness {

    private final UserRepository repository;

    private final UserConverter converter;

    private final TokenHandler tokenHandler;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

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
}
