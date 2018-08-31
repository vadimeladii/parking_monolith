package md.utm.fcim.parking_monolith.webservice.converter;

import md.utm.fcim.parking_monolith.business.dto.Camera;
import md.utm.fcim.parking_monolith.webservice.view.CameraView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 04/01/2018
 */
@Component
public class CameraViewConverter extends AbstractViewConverter<CameraView, Camera> {

    private ParkingLotViewConverter parkingLotViewConverter;

    public CameraViewConverter(ParkingLotViewConverter parkingLotViewConverter) {
        super(CameraView::new, Camera::new);
        this.parkingLotViewConverter = parkingLotViewConverter;
    }

    @Override
    protected Camera doForward(CameraView view) {
        Camera dto = super.doForward(view);
        dto.setNumber(view.getNumber());
        dto.setParkingLot(parkingLotViewConverter.convert(view.getParkingLot()));
        return dto;
    }

    @Override
    protected CameraView doBackward(Camera dto) {
        CameraView view = super.doBackward(dto);
        view.setNumber(dto.getNumber());
        view.setParkingLot(parkingLotViewConverter.reverse().convert(dto.getParkingLot()));
        return view;
    }
}
