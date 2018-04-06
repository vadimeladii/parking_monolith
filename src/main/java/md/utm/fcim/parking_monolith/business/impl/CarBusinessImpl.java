package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.CarBusiness;
import md.utm.fcim.parking_monolith.business.converter.CarConverter;
import md.utm.fcim.parking_monolith.business.dto.Car;
import md.utm.fcim.parking_monolith.repository.CarRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by veladii on 04/04/2018
 */
@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CarBusinessImpl implements CarBusiness {

    private final CarRepository repository;
    private final CarConverter converter;

    @Override
    public List<Car> retrieve() {
        return repository
                .findAll()
                .stream()
                .map(converter.reverse()::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Car> retrieveById(Long id) {
        return repository
                .findById(id)
                .map(converter.reverse()::convert);
    }

    @Override
    @Transactional
    public Car create(Car dto) {
        return converter.reverse().convert(repository.save(converter.convert(dto)));
    }
}
