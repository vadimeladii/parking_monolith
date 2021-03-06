package md.utm.fcim.parking_monolith.business.dto;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by veladii on 03/18/2018
 */
@Getter
@Setter
public class User extends AbstractDto {

    private String username;

    private String password;

    private String email;

    private BigDecimal balance;

    private Set<Role> roles = new HashSet<>();
}
