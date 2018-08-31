package md.utm.fcim.parking_monolith.business.converter;

import com.google.common.base.Converter;
import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.dto.AbstractDto;
import md.utm.fcim.parking_monolith.repository.entity.AbstractEntity;

import java.util.function.Supplier;

/**
 * Created by veladii on 03/19/2018
 */
@RequiredArgsConstructor
public abstract class AbstractConverter<D extends AbstractDto, E extends AbstractEntity> extends Converter<D, E> {

    private final Supplier<D> dtoSupplier;
    private final Supplier<E> entitySupplier;

    @Override
    protected E doForward(D dto) {
        E entity = entitySupplier.get();
        entity.setId(dto.getId());
        return entity;
    }

    @Override
    protected D doBackward(E entity) {
        D dto = dtoSupplier.get();
        dto.setId(entity.getId());
        return dto;
    }
}
