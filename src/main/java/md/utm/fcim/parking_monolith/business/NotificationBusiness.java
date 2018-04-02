package md.utm.fcim.parking_monolith.business;

import md.utm.fcim.parking_monolith.business.dto.Notification;

/**
 * Created by veladii on 03/24/2018
 */
public interface NotificationBusiness {

    Notification create(Notification dto);

    Void send(Long parkingId);
}
