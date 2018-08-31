package md.utm.fcim.parking_monolith.business.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.ParkingLotBusiness;
import md.utm.fcim.parking_monolith.business.converter.ParkingLotConverter;
import md.utm.fcim.parking_monolith.business.dto.ParkingLot;
import md.utm.fcim.parking_monolith.repository.ParkingLotRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by veladii on 03/17/2018
 */
@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ParkingLotBusinessImpl implements ParkingLotBusiness {

    private final ParkingLotRepository repository;
    private final ParkingLotConverter converter;

    @Override
    public List<ParkingLot> retrieve() {
        return repository.findAll()
                .stream()
                .map(converter.reverse()::convert)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ParkingLot> retrieveById(Long id) {
        return repository.findById(id).map(converter.reverse()::convert);
    }

    @Override
    @Transactional
    public Optional<ParkingLot> increment(Long id) {
        repository.increment(id);
        return retrieveById(id);
    }

    @Override
    @Transactional
    public Optional<ParkingLot> decrement(Long id) {
        repository.decrement(id);
        return retrieveById(id);
    }
}
