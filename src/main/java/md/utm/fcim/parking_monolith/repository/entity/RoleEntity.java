package md.utm.fcim.parking_monolith.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by veladii on 03/18/2018
 */
@Entity
@Table(
        name = "role",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"type"})
        }
)
@Getter
@Setter
public class RoleEntity extends AbstractEntity {

    private String type;
}
