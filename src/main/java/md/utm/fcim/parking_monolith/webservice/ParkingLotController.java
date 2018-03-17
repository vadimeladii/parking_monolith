package md.utm.fcim.parking_monolith.webservice;

import md.utm.fcim.parking_monolith.repository.ParkinLotRepository;
import md.utm.fcim.parking_monolith.repository.entity.ParkingLotEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/parking-lot")
public class ParkingLotController {

    @Autowired
    private ParkinLotRepository repository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public List<ParkingLotEntity> greeting() {
        return repository.findAll();
    }
}
