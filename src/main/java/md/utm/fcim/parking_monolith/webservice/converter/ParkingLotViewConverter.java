package md.utm.fcim.parking_monolith.webservice.converter;

import com.google.common.base.Converter;
import md.utm.fcim.parking_monolith.business.dto.ParkingLot;
import md.utm.fcim.parking_monolith.webservice.view.ParkingLotView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/17/2018
 */
@Component
public class ParkingLotViewConverter extends Converter<ParkingLotView, ParkingLot> {

    @Override
    protected ParkingLot doForward(ParkingLotView view) {
        ParkingLot dto = new ParkingLot();
        dto.setIdParking(view.getIdParking());
        dto.setName(view.getName());
        dto.setTotalPlaces(view.getTotalPlaces());
        dto.setAvailablePlaces(view.getAvailablePlaces());
        return dto;
    }

    @Override
    protected ParkingLotView doBackward(ParkingLot dto) {
        ParkingLotView view = new ParkingLotView();
        view.setIdParking(dto.getIdParking());
        view.setName(dto.getName());
        view.setTotalPlaces(dto.getTotalPlaces());
        view.setAvailablePlaces(dto.getAvailablePlaces());
        return view;
    }
}
