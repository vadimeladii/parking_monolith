package md.utm.fcim.parking_monolith.business;

import md.utm.fcim.parking_monolith.business.dto.Camera;

import java.util.List;
import java.util.Optional;

/**
 * Created by veladii on 04/01/2018
 */
public interface CameraBusiness {
    List<Camera> retrieve();

    Optional<Camera> retrieveById(Long id);

    Camera create(Camera dto);
}
