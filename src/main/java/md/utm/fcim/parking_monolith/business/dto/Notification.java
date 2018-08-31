package md.utm.fcim.parking_monolith.business.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by veladii on 03/24/2018
 */
@Getter
@Setter
public class Notification extends AbstractDto {

    private String token;

    private ParkingLot parkingLot;
}
