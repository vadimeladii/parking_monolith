package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.CameraBusiness;
import md.utm.fcim.parking_monolith.business.EntryBusiness;
import md.utm.fcim.parking_monolith.business.ParkingLotBusiness;
import md.utm.fcim.parking_monolith.business.dto.Camera;
import md.utm.fcim.parking_monolith.business.dto.Entry;
import md.utm.fcim.parking_monolith.business.dto.ParkingLot;
import org.springframework.stereotype.Service;

/**
 * Created by veladii on 04/09/2018
 */
@Service
@RequiredArgsConstructor
public class EntryBusinessImpl implements EntryBusiness {

    private final CameraBusiness cameraBusiness;
    private final ParkingLotBusiness parkingLotBusiness;
    private final NotificationBusinessImpl notificationBusiness;

    @Override
    public void increment(Entry entry) {
//        TODO add verify check for cameraNumber and carNumber
        ParkingLot parkingLot = cameraBusiness
                .retrieveByNumber(entry.getCameraNumber())
                .map(Camera::getParkingLot)
                .map(ParkingLot::getId)
                .flatMap(parkingLotBusiness::increment)
                .get();
        sendNotification(parkingLot);
    }

    @Override
    public void decrement(Entry entry) {
//        TODO add verify check for cameraNumber and carNumber
        ParkingLot parkingLot = cameraBusiness
                .retrieveByNumber(entry.getCameraNumber())
                .map(Camera::getParkingLot)
                .map(ParkingLot::getId)
                .flatMap(parkingLotBusiness::decrement)
                .get();
        sendNotification(parkingLot);
    }

    private void sendNotification(ParkingLot parkingLot) {
        if (parkingLot.getAvailablePlaces() < 10)
            notificationBusiness.send(parkingLot.getId());
    }
}
