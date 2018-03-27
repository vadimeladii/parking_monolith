package md.utm.fcim.parking_monolith.business.converter;

import md.utm.fcim.parking_monolith.business.dto.Notification;
import md.utm.fcim.parking_monolith.repository.entity.NotificationEntity;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/24/2018
 */
@Component
public class NotificationConverter extends AbstractConverter<Notification, NotificationEntity> {

    private final ParkingLotConverter parkingLotConverter;

    public NotificationConverter(ParkingLotConverter parkingLotConverter) {
        super(Notification::new, NotificationEntity::new);
        this.parkingLotConverter = parkingLotConverter;
    }

    @Override
    protected NotificationEntity doForward(Notification dto) {
        NotificationEntity entity = super.doForward(dto);
        entity.setToken(dto.getToken());
        entity.setParkingLotEntity(parkingLotConverter.convert(dto.getParkingLot()));
        return entity;
    }

    @Override
    protected Notification doBackward(NotificationEntity entity) {
        Notification dto = super.doBackward(entity);
        dto.setToken(entity.getToken());
        dto.setParkingLot(parkingLotConverter.reverse().convert(entity.getParkingLotEntity()));
        return dto;
    }
}
