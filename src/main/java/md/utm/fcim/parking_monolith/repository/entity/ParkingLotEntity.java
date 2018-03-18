package md.utm.fcim.parking_monolith.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "parking_lot")
@Getter
@Setter
public class ParkingLotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idParking;

    private String name;

    private Integer totalPlaces;

    private Integer availablePlaces;
}
