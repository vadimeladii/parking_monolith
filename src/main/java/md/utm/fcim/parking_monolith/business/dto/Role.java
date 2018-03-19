package md.utm.fcim.parking_monolith.business.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by veladii on 03/18/2018
 */
@Getter
@Setter
public class Role implements GrantedAuthority {

    private Long idRole;

    private String type;

    @Override
    public String getAuthority() {
        return type;
    }
}
