package md.utm.fcim.parking_monolith.webservice.view;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by veladii on 03/24/2018
 */
@Getter
@Setter
public class NotificationView extends AbstractView {

    private static final long serialVersionUID = -4434163669793946232L;

    private String token;

    private ParkingLotView parkingLot;
}
