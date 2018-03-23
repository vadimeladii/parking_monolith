package md.utm.fcim.parking_monolith.business.enums;

/**
 * Created by veladii on 03/22/2018
 */
public enum RoleType {
    SIMPLE("SIMPLE"), ADMIN("ADMIN");

    private String type;

    RoleType(String type) {
        this.type = type;
    }
}
