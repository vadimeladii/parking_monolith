package md.utm.fcim.parking_monolith.business.converter;

import com.google.common.base.Converter;
import md.utm.fcim.parking_monolith.business.dto.ParkingLot;
import md.utm.fcim.parking_monolith.repository.entity.ParkingLotEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/17/2018
 */
@Component
public class ParkingLotConverter extends Converter<ParkingLot, ParkingLotEntity> {

    @Override
    protected ParkingLotEntity doForward(ParkingLot dto) {
        ParkingLotEntity entity = new ParkingLotEntity();
        entity.setIdParking(dto.getIdParking());
        entity.setName(dto.getName());
        entity.setTotalPlaces(dto.getTotalPlaces());
        entity.setAvailablePlaces(dto.getAvailablePlaces());
        return entity;
    }

    @Override
    protected ParkingLot doBackward(ParkingLotEntity entity) {
        ParkingLot dto = new ParkingLot();
        dto.setIdParking(entity.getIdParking());
        dto.setName(entity.getName());
        dto.setTotalPlaces(entity.getTotalPlaces());
        dto.setAvailablePlaces(entity.getAvailablePlaces());
        return dto;
    }
}
