package md.utm.fcim.parking_monolith.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import static javax.persistence.CascadeType.*;

/**
 * Created by veladii on 03/18/2018
 */
@Entity
@Table(
        name = "`user`",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"username", "email"})
        }
)
@Getter
@Setter
public class UserEntity extends AbstractEntity {

    private String username;

    private String password;

    private String email;

    private BigDecimal balance;

    @ManyToMany(fetch = FetchType.LAZY, cascade = {MERGE, REMOVE, REFRESH, DETACH})
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "id_user")},
            inverseJoinColumns = {@JoinColumn(name = "id_role")})
    private Set<RoleEntity> roles = new HashSet<>();
}
