package md.utm.fcim.parking_monolith.webservice.converter;

import md.utm.fcim.parking_monolith.business.dto.ParkingLot;
import md.utm.fcim.parking_monolith.webservice.view.ParkingLotView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 03/17/2018
 */
@Component
public class ParkingLotViewConverter extends AbstractViewConverter<ParkingLotView, ParkingLot> {

    public ParkingLotViewConverter() {
        super(ParkingLotView::new, ParkingLot::new);
    }

    @Override
    protected ParkingLot doForward(ParkingLotView view) {
        ParkingLot dto = super.doForward(view);
        dto.setName(view.getName());
        dto.setTotalPlaces(view.getTotalPlaces());
        dto.setAvailablePlaces(view.getAvailablePlaces());
        return dto;
    }

    @Override
    protected ParkingLotView doBackward(ParkingLot dto) {
        ParkingLotView view = super.doBackward(dto);
        view.setName(dto.getName());
        view.setTotalPlaces(dto.getTotalPlaces());
        view.setAvailablePlaces(dto.getAvailablePlaces());
        return view;
    }
}
