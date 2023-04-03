package auto.rota.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.DependsOn;

@SpringBootApplication
@DependsOn("flywayInitializer")
public class RotaApplication {

    public static void main(String[] args) {
        SpringApplication.run(RotaApplication.class, args);
    }

}
