package md.utm.fcim.parking_monolith.business.converter;

import md.utm.fcim.parking_monolith.business.dto.Camera;
import md.utm.fcim.parking_monolith.repository.entity.CameraEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 04/01/2018
 */
@Component
public class CameraConverter extends AbstractConverter<Camera, CameraEntity> {

    private ParkingLotConverter parkingLotConverter;

    public CameraConverter(ParkingLotConverter parkingLotConverter) {
        super(Camera::new, CameraEntity::new);
        this.parkingLotConverter = parkingLotConverter;
    }

    @Override
    protected CameraEntity doForward(Camera dto) {
        CameraEntity entity = super.doForward(dto);
        entity.setNumber(dto.getNumber());
        entity.setParkingLot(parkingLotConverter.convert(dto.getParkingLot()));
        return entity;
    }

    @Override
    protected Camera doBackward(CameraEntity entity) {
        Camera dto = super.doBackward(entity);
        dto.setNumber(entity.getNumber());
        dto.setParkingLot(parkingLotConverter.reverse().convert(entity.getParkingLot()));
        return dto;
    }
}
