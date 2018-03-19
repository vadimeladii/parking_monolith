package md.utm.fcim.parking_monolith.repository.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * Created by veladii on 03/18/2018
 */
@Entity
@Table(name = "role")
@Data
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idRole;

    private String type;
}