package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.webservice.view.CarView;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by veladii on 04/04/2018
 */
@RequestMapping(value = "/car")
public interface CarController {

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CarView> create(CarView view);

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<CarView>> retrieve();

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<CarView> retrieveById(@PathVariable("id") Long id);
}
