package md.utm.fcim.parking_monolith.business.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

/**
 * Created by veladii on 03/18/2018
 */
@Getter
@Setter
public class Role extends AbstractDto implements GrantedAuthority {

    private String type;

    @Override
    public String getAuthority() {
        return type;
    }
}
