package md.utm.fcim.parking_monolith.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.ParkingLotBusiness;
import md.utm.fcim.parking_monolith.business.dto.ParkingLot;
import md.utm.fcim.parking_monolith.webservice.ParkingLotController;
import md.utm.fcim.parking_monolith.webservice.converter.ParkingLotViewConverter;
import md.utm.fcim.parking_monolith.webservice.view.ParkingLotView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by veladii on 03/17/2018
 */
@RestController
@RequiredArgsConstructor
public class ParkingLotControllerImpl implements ParkingLotController {

    private final ParkingLotBusiness business;
    private final ParkingLotViewConverter converter;

    public ResponseEntity<List<ParkingLotView>> retrieve() {
        List<ParkingLot> parkingLots = business.retrieve();
        return ResponseEntity
                .status(parkingLots.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
                .body(parkingLots
                        .stream()
                        .map(converter.reverse()::convert)
                        .collect(Collectors.toList()));

    }

    @Override
    public ResponseEntity<ParkingLotView> retrieveById(Long id) {
        Optional<ParkingLot> parkingLot = business.retrieveById(id);
        return ResponseEntity
                .status(parkingLot.isPresent() ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(parkingLot
                        .map(converter.reverse()::convert)
                        .orElse(null));
    }
}
