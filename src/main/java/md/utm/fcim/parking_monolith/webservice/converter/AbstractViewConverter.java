package md.utm.fcim.parking_monolith.webservice.converter;


import com.google.common.base.Converter;
import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.dto.AbstractDto;
import md.utm.fcim.parking_monolith.webservice.view.AbstractView;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

/**
 * Created by veladii on 03/19/2018
 */
@RequiredArgsConstructor
@Component
public abstract class AbstractViewConverter<V extends AbstractView, D extends AbstractDto> extends Converter<V, D> {

    private final Supplier<V> viewSupplier;
    private final Supplier<D> dtoSupplier;

    @Override
    protected D doForward(V view) {
        D dto = dtoSupplier.get();
        dto.setId(view.getId());
        return dto;
    }

    @Override
    protected V doBackward(D dto) {
        V view = viewSupplier.get();
        view.setId(dto.getId());
        return view;
    }
}
