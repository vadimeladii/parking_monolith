package md.utm.fcim.parking_monolith.business.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by veladii on 03/17/2018
 */
@Getter
@Setter
public class ParkingLot {

    private Long idParking;

    private String name;

    private Integer totalPlaces;

    private Integer availablePlaces;
}
