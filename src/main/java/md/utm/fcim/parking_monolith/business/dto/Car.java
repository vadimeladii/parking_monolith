package md.utm.fcim.parking_monolith.business.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by veladii on 04/02/2018
 */
@Getter
@Setter
public class Car extends AbstractDto {

    private String number;

    private User user;
}
