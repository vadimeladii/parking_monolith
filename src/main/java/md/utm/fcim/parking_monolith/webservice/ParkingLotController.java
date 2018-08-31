package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.webservice.view.ParkingLotView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by veladii on 03/17/2018
 */
@RequestMapping(value = "/parking-lot")
public interface ParkingLotController {

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<ParkingLotView>> retrieve();

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<ParkingLotView> retrieveById(@PathVariable("id") Long id);
}
