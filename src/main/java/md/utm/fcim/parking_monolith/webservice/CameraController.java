package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.webservice.view.CameraView;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by veladii on 04/01/2018
 */
@RequestMapping(value = "/camera")
public interface CameraController {

    @CrossOrigin
    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CameraView> create(CameraView view);

    @CrossOrigin
    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<CameraView>> retrieve();

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<CameraView> retrieveById(@PathVariable("id") Long id);
}
