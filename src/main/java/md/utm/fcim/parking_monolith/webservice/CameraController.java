package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.webservice.view.CameraView;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by veladii on 04/01/2018
 */
@RequestMapping(value = "/camera")
public interface CameraController {

    @RequestMapping(
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<CameraView> create(@RequestParam CameraView view);

    @RequestMapping(method = RequestMethod.GET)
    ResponseEntity<List<CameraView>> retrieve();

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    ResponseEntity<CameraView> retrieveById(@PathVariable("id") Long id);

}
