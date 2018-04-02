package md.utm.fcim.parking_monolith.business.notification;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

/**
 * Created by veladii on 03/24/2018
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class FirebaseResponse {

    private long multicast_id;

    private Integer success;

    private Integer failure;

    private Object canonical_ids;

    private Object results;
}
