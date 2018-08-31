package md.utm.fcim.parking_monolith.webservice.converter;

import md.utm.fcim.parking_monolith.business.dto.Car;
import md.utm.fcim.parking_monolith.webservice.view.CarView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 04/03/2018
 */
@Component
public class CarViewConverter extends AbstractViewConverter<CarView, Car> {

    private UserViewConverter userViewConverter;

    public CarViewConverter(UserViewConverter userViewConverter) {
        super(CarView::new, Car::new);
        this.userViewConverter = userViewConverter;
    }

    @Override
    protected Car doForward(CarView view) {
        Car dto = super.doForward(view);
        dto.setNumber(view.getNumber());
        dto.setUser(userViewConverter.convert(view.getUserView()));
        return dto;
    }

    @Override
    protected CarView doBackward(Car dto) {
        CarView view = super.doBackward(dto);
        view.setNumber(dto.getNumber());
        view.setUserView(userViewConverter.reverse().convert(dto.getUser()));
        return view;
    }
}
