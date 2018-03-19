package md.utm.fcim.parking_monolith.business.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Set;

/**
 * Created by veladii on 03/18/2018
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserSecurity implements UserDetails {

    private Set<Role> authorities;
    private String password;
    private String username;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private boolean enabled;
}
