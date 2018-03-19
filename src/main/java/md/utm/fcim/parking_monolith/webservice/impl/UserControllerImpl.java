package md.utm.fcim.parking_monolith.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.UserBusiness;
import md.utm.fcim.parking_monolith.webservice.UserController;
import md.utm.fcim.parking_monolith.webservice.converter.TokenViewConverter;
import md.utm.fcim.parking_monolith.webservice.view.TokenView;
import md.utm.fcim.parking_monolith.webservice.view.UserSimpleView;
import org.springframework.web.bind.annotation.*;

/**
 * Created by veladii on 03/18/2018
 */
@RestController
@RequiredArgsConstructor
public class UserControllerImpl implements UserController {

    private final UserBusiness userBusiness;

    private final TokenViewConverter tokenViewConverter;

    public TokenView login(UserSimpleView view) {
        return userBusiness.login(view)
                .map(tokenViewConverter.reverse()::convert)
                .orElse(null);
    }
}