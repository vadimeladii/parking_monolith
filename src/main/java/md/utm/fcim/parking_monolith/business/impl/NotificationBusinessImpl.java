package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.NotificationBusiness;
import md.utm.fcim.parking_monolith.business.converter.NotificationConverter;
import md.utm.fcim.parking_monolith.business.dto.Notification;
import md.utm.fcim.parking_monolith.business.notification.AndroidPushNotificationsService;
import md.utm.fcim.parking_monolith.business.notification.FirebaseResponse;
import md.utm.fcim.parking_monolith.repository.NotificationRepository;
import md.utm.fcim.parking_monolith.repository.ParkingLotRepository;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * Created by veladii on 03/24/2018
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class NotificationBusinessImpl implements NotificationBusiness {

    private final AndroidPushNotificationsService androidPushNotificationsService;
    private final NotificationRepository repository;
    private final NotificationConverter converter;
    private final ParkingLotRepository parkingLotRepository;

    @Override
    @Transactional
    public Notification create(Notification dto) {
        return converter.reverse().convert(repository.save(converter.convert(dto)));
    }

    @Override
    public Void send(Long parkingId) {
        repository.findByParkingLotEntity(parkingLotRepository.findById(parkingId).orElse(null))
                .forEach(parking -> {
                    sendNotification(parking.getToken(), parking.getParkingLotEntity().getAvailablePlaces());
                });
        return null;
    }

    private ResponseEntity<String> sendNotification(String token, Integer counter) {
        JSONObject body = new JSONObject();
        body.put("to", token);
        body.put("priority", "high");
        body.put("sound", "default");

        JSONObject notification = new JSONObject();
        notification.put("body", "There are " + (counter) + " places left");
        notification.put("title", "ParkIt");

        body.put("notification", notification);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<FirebaseResponse> pushNotification = androidPushNotificationsService.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            FirebaseResponse firebaseResponse = pushNotification.get();
            if (firebaseResponse.getSuccess() == 1) {
                System.out.println("push notification sent ok!");
            } else {
                System.out.println("error sending push notifications: " + firebaseResponse.toString());
            }
            return new ResponseEntity<>(firebaseResponse.toString(), HttpStatus.OK);

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>("the push notification cannot be send.", HttpStatus.BAD_REQUEST);
    }
}
