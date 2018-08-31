package md.utm.fcim.parking_monolith.business;

import md.utm.fcim.parking_monolith.business.dto.Entry;

/**
 * Created by veladii on 04/09/2018
 */
public interface EntryBusiness {

    void increment(Entry entry);

    void decrement(Entry entry);
}
