package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.CameraBusiness;
import md.utm.fcim.parking_monolith.business.CarBusiness;
import md.utm.fcim.parking_monolith.business.EntryBusiness;
import md.utm.fcim.parking_monolith.business.ParkingLotBusiness;
import md.utm.fcim.parking_monolith.business.dto.Camera;
import md.utm.fcim.parking_monolith.business.dto.Entry;
import md.utm.fcim.parking_monolith.business.dto.ParkingLot;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

/**
 * Created by veladii on 04/09/2018
 */
@Service
@RequiredArgsConstructor
public class EntryBusinessImpl implements EntryBusiness {

    private final CameraBusiness cameraBusiness;
    private final ParkingLotBusiness parkingLotBusiness;
    private final NotificationBusinessImpl notificationBusiness;
    private final CarBusiness carBusiness;

    @Override
    public void increment(Entry entry) {
//        TODO add verify check for cameraNumber and carNumber
        if(carBusiness.exist(entry.getCarNumber())) {
            cameraBusiness
                    .retrieveByNumber(entry.getCameraNumber())
                    .map(Camera::getParkingLot)
                    .map(ParkingLot::getId)
                    .flatMap(parkingLotBusiness::increment)
                    .ifPresent(p -> {
                        this.httpPostRequest(entry.getCarNumber());
                        this.sendNotification(p);
                    });
        }
    }

    @Override
    public void decrement(Entry entry) {
//        TODO add verify check for cameraNumber and carNumber
        if(carBusiness.exist(entry.getCarNumber())) {
            cameraBusiness
                    .retrieveByNumber(entry.getCameraNumber())
                    .map(Camera::getParkingLot)
                    .map(ParkingLot::getId)
                    .flatMap(parkingLotBusiness::decrement)
                    .ifPresent(p -> {
                        this.httpPostRequest(entry.getCarNumber());
                        this.sendNotification(p);
                    });        }
    }

    private void httpPostRequest(String carNumber) {
        String url = "http://167.99.18.104/gateSocket/";

        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> map= new LinkedMultiValueMap<>();
        map.add("plate", carNumber);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(map, headers);

        restTemplate.postForEntity(url, request, Void.class);
    }

    private void sendNotification(ParkingLot parkingLot) {
        if (parkingLot.getAvailablePlaces() < 10)
            notificationBusiness.send(parkingLot.getId());
    }
}
