package md.utm.fcim.parking_monolith.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.NotificationBusiness;
import md.utm.fcim.parking_monolith.webservice.NotificationController;
import md.utm.fcim.parking_monolith.webservice.converter.NotificationViewConverter;
import md.utm.fcim.parking_monolith.webservice.view.NotificationView;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by veladii on 03/24/2018
 */
@RestController
@RequiredArgsConstructor
public class NotificationControllerImpl implements NotificationController {

    private final NotificationBusiness business;
    private final NotificationViewConverter converter;

    @Override
    public ResponseEntity<NotificationView> create(NotificationView view) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(converter.reverse().convert(business.create(converter.convert(view))));
    }

    @Override
    public ResponseEntity<Void> send(Long parkingId) {
        return ResponseEntity.ok(business.send(parkingId));
    }
}
