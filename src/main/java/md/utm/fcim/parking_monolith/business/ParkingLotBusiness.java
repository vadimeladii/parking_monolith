package md.utm.fcim.parking_monolith.business;

import md.utm.fcim.parking_monolith.business.dto.ParkingLot;

/**
 * Created by veladii on 03/17/2018
 */
import java.util.List;
import java.util.Optional;

public interface ParkingLotBusiness {
    List<ParkingLot> retrieve();

    Optional<ParkingLot> retrieveById(Long id);

    Optional<ParkingLot> increment(Long id);

    Optional<ParkingLot> decrement(Long id);
}
