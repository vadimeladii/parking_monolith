package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.NotificationBusiness;
import md.utm.fcim.parking_monolith.business.converter.NotificationConverter;
import md.utm.fcim.parking_monolith.business.dto.Notification;
import md.utm.fcim.parking_monolith.business.notification.AndroidPushNotificationsService;
import md.utm.fcim.parking_monolith.repository.NotificationRepository;
import md.utm.fcim.parking_monolith.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by veladii on 03/24/2018
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationBusinessImpl implements NotificationBusiness {

    private final AndroidPushNotificationsService pushNotificationsService;
    private final NotificationRepository repository;
    private final NotificationConverter converter;
    private final ParkingLotRepository parkingLotRepository;

    @Override
    @Transactional
    public Notification create(Notification dto) {
        return converter.reverse().convert(repository.save(converter.convert(dto)));
    }

    @Override
    public void send(Long parkingId) {
        repository.findByParkingLotEntity(parkingLotRepository.findById(parkingId).orElse(null))
                .forEach(parking -> {
                    pushNotificationsService.sendNotification(
                            parking.getToken(),
                            parking.getParkingLotEntity().getAvailablePlaces());
                });
    }
}
