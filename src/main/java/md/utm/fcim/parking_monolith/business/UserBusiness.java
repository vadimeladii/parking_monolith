package md.utm.fcim.parking_monolith.business;

import md.utm.fcim.parking_monolith.business.dto.Token;
import md.utm.fcim.parking_monolith.business.dto.User;
import md.utm.fcim.parking_monolith.webservice.view.UserSimpleView;

import java.util.Optional;

/**
 * Created by veladii on 03/18/2018
 */
public interface UserBusiness {
    Optional<User> findByUsername(String username);

    Optional<Token> login(UserSimpleView view);
}
