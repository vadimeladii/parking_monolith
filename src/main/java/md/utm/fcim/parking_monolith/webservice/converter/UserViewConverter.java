package md.utm.fcim.parking_monolith.webservice.converter;

import md.utm.fcim.parking_monolith.business.dto.User;
import md.utm.fcim.parking_monolith.webservice.view.UserView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/19/2018
 */
@Component
public class UserViewConverter extends AbstractViewConverter<UserView, User> {

    public UserViewConverter() {
        super(UserView::new, User::new);
    }

    @Override
    protected User doForward(UserView view) {
        User dto = super.doForward(view);
        dto.setUsername(view.getUsername());
        dto.setPassword(view.getPassword());
        dto.setEmail(view.getEmail());
        dto.setBalance(view.getBalance());
        return dto;
    }

    @Override
    protected UserView doBackward(User dto) {
        UserView view = super.doBackward(dto);
        view.setUsername(dto.getUsername());
        view.setPassword(dto.getPassword());
        view.setEmail(dto.getEmail());
        view.setBalance(dto.getBalance());
        return view;
    }
}
