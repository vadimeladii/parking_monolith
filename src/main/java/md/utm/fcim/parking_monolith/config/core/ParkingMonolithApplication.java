package md.utm.fcim.parking_monolith.config.core;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("md.utm.fcim")
@EnableJpaRepositories("md.utm.fcim")
@ComponentScan(value = "md.utm.fcim")
public class ParkingMonolithApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParkingMonolithApplication.class, args);
    }
}
