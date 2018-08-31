package md.utm.fcim.parking_monolith.business.converter;

import md.utm.fcim.parking_monolith.business.dto.Car;
import md.utm.fcim.parking_monolith.repository.entity.CarEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 04/03/2018
 */
@Component
public class CarConverter extends AbstractConverter<Car, CarEntity> {

    private UserConverter userConverter;

    public CarConverter(UserConverter userConverter) {
        super(Car::new, CarEntity::new);
        this.userConverter = userConverter;
    }

    @Override
    protected CarEntity doForward(Car dto) {
        CarEntity entity = super.doForward(dto);
        entity.setNumber(dto.getNumber());
        entity.setUserEntity(userConverter.convert(dto.getUser()));
        return entity;
    }

    @Override
    protected Car doBackward(CarEntity entity) {
        Car dto = super.doBackward(entity);
        dto.setNumber(entity.getNumber());
        dto.setUser(userConverter.reverse().convert(entity.getUserEntity()));
        return dto;
    }
}
