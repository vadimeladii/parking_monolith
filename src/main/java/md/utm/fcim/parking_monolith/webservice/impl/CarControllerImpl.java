package md.utm.fcim.parking_monolith.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.CarBusiness;
import md.utm.fcim.parking_monolith.business.dto.Car;
import md.utm.fcim.parking_monolith.webservice.CarController;
import md.utm.fcim.parking_monolith.webservice.converter.CarViewConverter;
import md.utm.fcim.parking_monolith.webservice.view.CarView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by veladii on 04/04/2018
 */
@RestController
@RequiredArgsConstructor
public class CarControllerImpl implements CarController {

    private final CarBusiness business;
    private final CarViewConverter converter;

    @Override
    public ResponseEntity<CarView> create(CarView view) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(converter.reverse().convert(business.create(converter.convert(view))));
    }

    @Override
    public ResponseEntity<List<CarView>> retrieve() {
        List<Car> parkingLots = business.retrieve();
        return ResponseEntity
                .status(parkingLots.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
                .body(parkingLots
                        .stream()
                        .map(converter.reverse()::convert)
                        .collect(Collectors.toList()));
    }

    @Override
    public ResponseEntity<CarView> retrieveById(Long id) {
        Optional<Car> parkingLot = business.retrieveById(id);
        return ResponseEntity
                .status(parkingLot.isPresent() ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(parkingLot
                        .map(converter.reverse()::convert)
                        .orElse(null));
    }
}
