package md.utm.fcim.parking_monolith.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * Created by veladii on 03/24/2018
 */
@Entity
@Table(
        name = "notification",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"token"})
        }
)
@Getter
@Setter
public class NotificationEntity extends AbstractEntity {

    private String token;

    @ManyToOne
    @JoinColumn(name = "id_parking", nullable = false)
    private ParkingLotEntity parkingLotEntity;
}
