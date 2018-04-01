package md.utm.fcim.parking_monolith.webservice.view;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by veladii on 04/01/2018
 */
@Getter
@Setter
public class CameraView extends AbstractView {

    private String number;

    private ParkingLotView parkingLot;
}
