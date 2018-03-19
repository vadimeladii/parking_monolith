package md.utm.fcim.parking_monolith.webservice.view;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by veladii on 03/19/2018
 */
@Getter
@Setter
public abstract class AbstractView implements Serializable {

    private Long id;
}
