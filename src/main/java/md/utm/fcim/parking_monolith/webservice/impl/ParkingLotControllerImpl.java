package md.utm.fcim.parking_monolith.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.ParkingLotBusiness;
import md.utm.fcim.parking_monolith.webservice.ParkingLotController;
import md.utm.fcim.parking_monolith.webservice.converter.ParkingLotViewConverter;
import md.utm.fcim.parking_monolith.webservice.view.ParkingLotView;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class ParkingLotControllerImpl implements ParkingLotController {

    private final ParkingLotBusiness business;
    private final ParkingLotViewConverter converter;

    public List<ParkingLotView> retrieve() {
        return business.retrieve()
                .stream()
                .map(converter.reverse()::convert)
                .collect(Collectors.toList());
    }

    @Override
    public ParkingLotView retrieveById(Long id) {
        return business.retrieveById(id)
                .map(converter.reverse()::convert)
                .orElse(null);
    }
}
