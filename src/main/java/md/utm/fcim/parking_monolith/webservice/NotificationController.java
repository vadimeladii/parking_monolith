package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.webservice.view.NotificationView;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by veladii on 03/24/2018
 */
@RequestMapping(value = "/notification")
public interface NotificationController {

    @RequestMapping(method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<NotificationView> create(@RequestParam NotificationView view);

    @RequestMapping(value = "/send/{parkingId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> send(@PathVariable("parkingId") Long parkingId);
}
