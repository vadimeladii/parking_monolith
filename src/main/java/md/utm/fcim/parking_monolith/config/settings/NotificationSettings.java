package md.utm.fcim.parking_monolith.config.settings;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/**
 * Created by veladii on 03/27/2018
 */
@Configuration
@ConfigurationProperties(prefix = "notification", ignoreUnknownFields = false)
@Getter
@Setter
@Validated
public class NotificationSettings {
    private String firebaseServerKey;
    private String url;
}
