package md.utm.fcim.parking_monolith.business;

import md.utm.fcim.parking_monolith.business.dto.ParkingLot;

import java.util.List;
import java.util.Optional;

public interface ParkingLotBusiness {
    List<ParkingLot> retrieve();

    Optional<ParkingLot> retrieveById(Long id);
}
