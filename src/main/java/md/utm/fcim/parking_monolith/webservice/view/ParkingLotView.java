package md.utm.fcim.parking_monolith.webservice.view;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by veladii on 03/17/2018
 */
@Getter
@Setter
public class ParkingLotView extends AbstractView {

    private static final long serialVersionUID = 5410981616001172344L;
    
    private String name;

    private Integer totalPlaces;

    private Integer availablePlaces;

    private Integer surface;
}
