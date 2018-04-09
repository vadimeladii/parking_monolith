package md.utm.fcim.parking_monolith.webservice.view;

import lombok.Getter;
import lombok.Setter;

/**
 * Created by veladii on 04/02/2018
 */
@Getter
@Setter
public class CarView extends AbstractView {

    private String number;

    private UserView userView;
}
