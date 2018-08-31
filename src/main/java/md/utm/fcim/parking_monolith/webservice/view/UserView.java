package md.utm.fcim.parking_monolith.webservice.view;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by veladii on 03/19/2018
 */
@Getter
@Setter
@NoArgsConstructor
public class UserView extends AbstractView {

    private static final long serialVersionUID = 4069216647909045612L;

    private String username;

    private String password;

    private String email;

    private BigDecimal balance;
}
