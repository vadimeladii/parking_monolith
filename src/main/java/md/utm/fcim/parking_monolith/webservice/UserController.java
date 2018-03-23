package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.webservice.view.TokenView;
import md.utm.fcim.parking_monolith.webservice.view.UserSimpleView;
import md.utm.fcim.parking_monolith.webservice.view.UserView;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by veladii on 9/1/17.
 */
@RestController
@RequestMapping(value = "/user")
public interface UserController {

    @RequestMapping(
            value = "/login",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(value = HttpStatus.OK)
    TokenView login(@RequestBody UserSimpleView view);

    @RequestMapping(method = RequestMethod.POST,
                    produces = MediaType.APPLICATION_JSON_VALUE,
                    consumes = MediaType.APPLICATION_JSON_VALUE)
    UserView create(@RequestParam UserView view);
}