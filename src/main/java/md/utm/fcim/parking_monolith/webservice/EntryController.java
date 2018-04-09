package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.webservice.view.EntryView;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by veladii on 04/09/2018
 */
@RequestMapping(value = "/entry")
public interface EntryController {

    @RequestMapping(
            value = "/increment",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> increment(@RequestParam EntryView view);

    @RequestMapping(
            value = "/decrement",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> decrement(@RequestParam EntryView view);
}
