package md.utm.fcim.parking_monolith.business.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by veladii on 04/01/2018
 */
@Getter
@Setter
public class Camera extends AbstractDto {

    private String number;

    private ParkingLot parkingLot;
}
