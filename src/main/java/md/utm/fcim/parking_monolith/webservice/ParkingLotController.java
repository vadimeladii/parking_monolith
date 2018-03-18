package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.webservice.view.ParkingLotView;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@RequestMapping(value = "/parking-lot")
public interface ParkingLotController {

    @RequestMapping(method = RequestMethod.GET)
    List<ParkingLotView> retrieve();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ParkingLotView retrieveById(@PathVariable("id") Long id);
}
