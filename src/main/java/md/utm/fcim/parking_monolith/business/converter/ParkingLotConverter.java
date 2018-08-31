package md.utm.fcim.parking_monolith.business.converter;

import md.utm.fcim.parking_monolith.business.dto.ParkingLot;
import md.utm.fcim.parking_monolith.repository.entity.ParkingLotEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/17/2018
 */
@Component
public class ParkingLotConverter extends AbstractConverter<ParkingLot, ParkingLotEntity> {

    public ParkingLotConverter() {
        super(ParkingLot::new, ParkingLotEntity::new);
    }

    @Override
    protected ParkingLotEntity doForward(ParkingLot dto) {
        ParkingLotEntity entity = super.doForward(dto);
        entity.setName(dto.getName());
        entity.setTotalPlaces(dto.getTotalPlaces());
        entity.setAvailablePlaces(dto.getAvailablePlaces());
        entity.setSurface(dto.getSurface());
        return entity;
    }

    @Override
    protected ParkingLot doBackward(ParkingLotEntity entity) {
        ParkingLot dto = super.doBackward(entity);
        dto.setName(entity.getName());
        dto.setTotalPlaces(entity.getTotalPlaces());
        dto.setAvailablePlaces(entity.getAvailablePlaces());
        dto.setSurface(entity.getSurface());
        return dto;
    }
}
