package forexApp.configuration;

import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfiguration {

@Bean(name = "IMPORTANT")
    Marker getMarker() {
        return MarkerFactory.getMarker("IMPORTANT");
    }


}