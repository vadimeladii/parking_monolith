package md.utm.fcim.parking_monolith.webservice.view;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by veladii on 03/18/2018
 */
@Getter
@Setter
public class UserSimpleView implements Serializable {

    private static final long serialVersionUID = 8128290289723415885L;
    
    private String username;

    private String password;
}
