package md.utm.fcim.parking_monolith.business.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParkingLot {

    private Long idParking;

    private String name;

    private Integer totalPlaces;

    private Integer availablePlaces;
}
