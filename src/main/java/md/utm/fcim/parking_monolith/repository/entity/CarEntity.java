package md.utm.fcim.parking_monolith.repository.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Created by veladii on 04/02/2018
 */
@Entity
@Table(name = "car")
@Getter
@Setter
public class CarEntity extends AbstractEntity {

    private String number;

    @ManyToOne
    @JoinColumn(name = "id_user")
    private UserEntity userEntity;
}
