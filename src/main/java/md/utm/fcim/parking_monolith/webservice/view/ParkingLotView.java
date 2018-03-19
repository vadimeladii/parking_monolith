package md.utm.fcim.parking_monolith.webservice.view;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by veladii on 03/17/2018
 */
@Getter
@Setter
public class ParkingLotView implements Serializable {

    private static final long serialVersionUID = 5410981616001172344L;
    
    private Long idParking;

    private String name;

    private Integer totalPlaces;

    private Integer availablePlaces;
}
