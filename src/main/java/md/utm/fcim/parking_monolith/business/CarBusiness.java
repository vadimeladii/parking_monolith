package md.utm.fcim.parking_monolith.business;

import md.utm.fcim.parking_monolith.business.dto.Car;

import java.util.List;
import java.util.Optional;

/**
 * Created by veladii on 04/04/2018
 */
public interface CarBusiness {
    List<Car> retrieve();

    Optional<Car> retrieveById(Long id);

    Car create(Car dto);
}
