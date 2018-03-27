package md.utm.fcim.parking_monolith.webservice.converter;

import md.utm.fcim.parking_monolith.business.converter.ParkingLotConverter;
import md.utm.fcim.parking_monolith.business.dto.Notification;
import md.utm.fcim.parking_monolith.webservice.view.NotificationView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/24/2018
 */
@Component
public class NotificationViewConverter extends AbstractViewConverter<NotificationView, Notification> {

    private final ParkingLotViewConverter parkingLotViewConverter;

    public NotificationViewConverter(ParkingLotViewConverter parkingLotViewConverter) {
        super(NotificationView::new, Notification::new);
        this.parkingLotViewConverter = parkingLotViewConverter;
    }

    @Override
    protected Notification doForward(NotificationView view) {
        Notification dto = super.doForward(view);
        dto.setToken(view.getToken());
        dto.setParkingLot(parkingLotViewConverter.convert(view.getParkingLotView()));
        return dto;
    }

    @Override
    protected NotificationView doBackward(Notification dto) {
        NotificationView view = super.doBackward(dto);
        view.setToken(dto.getToken());
        view.setParkingLotView(parkingLotViewConverter.reverse().convert(dto.getParkingLot()));
        return view;
    }
}
