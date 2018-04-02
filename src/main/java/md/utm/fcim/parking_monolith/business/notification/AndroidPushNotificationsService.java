package md.utm.fcim.parking_monolith.business.notification;

import com.google.common.net.HttpHeaders;
import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.config.settings.NotificationSettings;
import org.json.simple.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static md.utm.fcim.parking_monolith.business.notification.constants.NotificationConstant.*;

/**
 * Created by veladii on 03/24/2018
 */
@Service
@RequiredArgsConstructor
public class AndroidPushNotificationsService {

    private final NotificationSettings settings;

    @Async
    public CompletableFuture<FirebaseResponse> send(HttpEntity<String> entity) {
        FirebaseResponse firebaseResponse = buildRestTemplate()
                .postForObject(settings.getUrl(), entity, FirebaseResponse.class);

        return CompletableFuture.completedFuture(firebaseResponse);
    }

    private RestTemplate buildRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
        interceptors.add(new HeaderRequestInterceptor(HttpHeaders.AUTHORIZATION, "key=" + settings.getFirebaseServerKey()));
        interceptors.add(new HeaderRequestInterceptor(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE));
        restTemplate.setInterceptors(interceptors);
        return restTemplate;
    }

    public void sendNotification(String token, Integer counter) {
        JSONObject body = new JSONObject();
        body.put(TO, token);
        body.put(PRIORITY, "high");
        body.put(SOUND, "default");

        JSONObject notification = new JSONObject();
        notification.put(BODY, "There are " + (counter) + " places left");
        notification.put(TITLE, "PARKING");

        body.put(NOTIFICATION, notification);

        HttpEntity<String> request = new HttpEntity<>(body.toString());

        CompletableFuture<FirebaseResponse> pushNotification = this.send(request);
        CompletableFuture.allOf(pushNotification).join();

        try {
            FirebaseResponse firebaseResponse = pushNotification.get();
            if (firebaseResponse.getSuccess() == 1) {
                System.out.println("push notification sent ok!");
            } else {
                System.out.println("error sending push notifications: " + firebaseResponse.toString());
            }
            new ResponseEntity<>(firebaseResponse.toString(), HttpStatus.OK);
            return;

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        new ResponseEntity<>("the push notification cannot be send.", HttpStatus.BAD_REQUEST);
    }
}
