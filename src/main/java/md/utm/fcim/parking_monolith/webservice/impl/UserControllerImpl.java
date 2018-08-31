package md.utm.fcim.parking_monolith.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.UserBusiness;
import md.utm.fcim.parking_monolith.business.dto.Token;
import md.utm.fcim.parking_monolith.business.dto.User;
import md.utm.fcim.parking_monolith.webservice.UserController;
import md.utm.fcim.parking_monolith.webservice.converter.TokenViewConverter;
import md.utm.fcim.parking_monolith.webservice.converter.UserViewConverter;
import md.utm.fcim.parking_monolith.webservice.view.TokenView;
import md.utm.fcim.parking_monolith.webservice.view.UserSimpleView;
import md.utm.fcim.parking_monolith.webservice.view.UserView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by veladii on 03/18/2018
 */
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserBusiness business;
    private final UserViewConverter converter;
    private final TokenViewConverter tokenViewConverter;

    public ResponseEntity<TokenView> login(UserSimpleView view) {
        Optional<Token> token = business.login(view);
        return ResponseEntity
                .status(token.isPresent() ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(token
                        .map(a -> tokenViewConverter.reverse().convert(a))
                        .orElse(null));
    }

    @Override
    public ResponseEntity<UserView> create(UserView view) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(converter.reverse().convert(business.create(converter.convert(view))));
    }

    @Override
    public ResponseEntity<List<UserView>> retrieve() {
        List<User> users = business.retrieve();
        return ResponseEntity
                .status(users.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
                .body(users
                        .stream()
                        .map(converter.reverse()::convert)
                        .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<UserView> retrieveById(Long id) {
        Optional<User> user = business.retrieveById(id);
        return ResponseEntity
                .status(user.isPresent() ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(user
                        .map(converter.reverse()::convert)
                        .orElse(null));
    }
}