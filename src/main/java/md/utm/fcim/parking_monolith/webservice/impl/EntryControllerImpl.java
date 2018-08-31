package md.utm.fcim.parking_monolith.webservice.impl;

import lombok.RequiredArgsConstructor;
import md.utm.fcim.parking_monolith.business.EntryBusiness;
import md.utm.fcim.parking_monolith.webservice.EntryController;
import md.utm.fcim.parking_monolith.webservice.converter.EntryViewConverter;
import md.utm.fcim.parking_monolith.webservice.view.EntryView;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by veladii on 04/09/2018
 */
@RestController
@RequiredArgsConstructor
public class EntryControllerImpl implements EntryController {

    private final EntryBusiness business;
    private final EntryViewConverter converter;

    @Override
    public ResponseEntity<?> increment(EntryView view) {
        business.increment(converter.convert(view));
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<?> decrement(EntryView view) {
        business.decrement(converter.convert(view));
        return ResponseEntity.ok().build();
    }
}
