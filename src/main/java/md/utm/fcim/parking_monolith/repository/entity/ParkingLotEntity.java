package md.utm.fcim.parking_monolith.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


/**
 * Created by veladii on 03/18/2018
 */
@Entity
@Table(
        name = "parking_lot",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"name"})
        }
)
@Getter
@Setter
public class ParkingLotEntity extends AbstractEntity {

    private String name;

    private Integer totalPlaces;

    private Integer availablePlaces;
}
