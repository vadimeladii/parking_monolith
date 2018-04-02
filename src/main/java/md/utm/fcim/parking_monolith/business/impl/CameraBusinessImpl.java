package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.CameraBusiness;
import md.utm.fcim.parking_monolith.business.converter.CameraConverter;
import md.utm.fcim.parking_monolith.business.dto.Camera;
import md.utm.fcim.parking_monolith.repository.CameraRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by veladii on 04/01/2018
 */
@Service
@RequiredArgsConstructor
public class CameraBusinessImpl implements CameraBusiness {

    private final CameraRepository repository;
    private final CameraConverter converter;

    @Override
    public List<Camera> retrieve() {
        return repository
                .findAll()
                .stream()
                .map(converter.reverse()::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Camera> retrieveById(Long id) {
        return repository
                .findById(id)
                .map(converter.reverse()::convert);
    }

    @Override
    public Camera create(Camera dto) {
        return converter.reverse().convert(repository.save(converter.convert(dto)));
    }
}
