package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.UserBusiness;
import md.utm.fcim.parking_monolith.business.dto.User;
import md.utm.fcim.parking_monolith.business.dto.UserSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by veladii on 03/18/2018
 */
@Service
@RequiredArgsConstructor
public class UserSecurityBusiness implements UserDetailsService {

    @Autowired
    private UserBusiness userBusiness;

    @Override
    public UserDetails loadUserByUsername(String username) {
        Optional<User> entity = userBusiness.findByUsername(username);
        if (entity.isPresent()) {
            return UserSecurity.builder()
                    .username(entity.get().getUsername())
                    .password(entity.get().getPassword())
                    .authorities(entity.get().getRoles())
                    .accountNonExpired(true)
                    .accountNonLocked(true)
                    .credentialsNonExpired(true)
                    .enabled(true)
                    .build();
        } else {
            throw new UsernameNotFoundException("user" + username + "wasn't fount");
        }
    }
}
