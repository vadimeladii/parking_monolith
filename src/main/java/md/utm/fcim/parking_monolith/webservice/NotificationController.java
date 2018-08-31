package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.webservice.view.NotificationView;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by veladii on 03/24/2018
 */
@RequestMapping(value = "/notification")
public interface NotificationController {

    @CrossOrigin
    @PostMapping
    ResponseEntity<NotificationView> create(@RequestBody NotificationView view);

    @CrossOrigin
    @RequestMapping(value = "/send/{parkingId}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> send(@PathVariable("parkingId") Long parkingId);
}
