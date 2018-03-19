package md.utm.fcim.parking_monolith.repository.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by veladii on 03/18/2018
 */
@Entity
@Table(name = "parking_lot")
@Data
public class ParkingLotEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idParking;

    private String name;

    private Integer totalPlaces;

    private Integer availablePlaces;
}
