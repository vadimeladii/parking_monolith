package md.utm.fcim.parking_monolith.webservice.converter;

import com.google.common.base.Converter;
import md.utm.fcim.parking_monolith.business.dto.Entry;
import md.utm.fcim.parking_monolith.webservice.view.EntryView;
import org.springframework.stereotype.Component;

/**
 * Created by veladii on 04/09/2018
 */
@Component
public class EntryViewConverter extends Converter<EntryView, Entry> {

    @Override
    protected Entry doForward(EntryView view) {
        Entry dto = new Entry();
        dto.setCarNumber(view.getCarNumber());
        dto.setCameraNumber(view.getCameraNumber());
        return dto;
    }

    @Override
    protected EntryView doBackward(Entry entry) {
        return null;
    }
}
