package md.utm.fcim.parking_monolith.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.CameraBusiness;
import md.utm.fcim.parking_monolith.business.dto.Camera;
import md.utm.fcim.parking_monolith.webservice.CameraController;
import md.utm.fcim.parking_monolith.webservice.converter.CameraViewConverter;
import md.utm.fcim.parking_monolith.webservice.view.CameraView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by veladii on 04/01/2018
 */
@RestController
@RequiredArgsConstructor
public class CameraControllerImpl implements CameraController {

    private final CameraBusiness business;
    private final CameraViewConverter converter;

    @Override
    public ResponseEntity<CameraView> create(CameraView view) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(converter.reverse().convert(business.create(converter.convert(view))));
    }

    public ResponseEntity<List<CameraView>> retrieve() {
        List<Camera> parkingLots = business.retrieve();
        return ResponseEntity
                .status(parkingLots.isEmpty() ? HttpStatus.NO_CONTENT : HttpStatus.OK)
                .body(parkingLots
                        .stream()
                        .map(converter.reverse()::convert)
                        .collect(Collectors.toList()));

    }

    @Override
    public ResponseEntity<CameraView> retrieveById(Long id) {
        Optional<Camera> parkingLot = business.retrieveById(id);
        return ResponseEntity
                .status(parkingLot.isPresent() ? HttpStatus.OK : HttpStatus.NO_CONTENT)
                .body(parkingLot
                        .map(converter.reverse()::convert)
                        .orElse(null));
    }
}
