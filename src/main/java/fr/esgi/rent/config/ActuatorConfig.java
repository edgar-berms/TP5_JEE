package fr.esgi.rent.config;

import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.actuate.info.InfoEndpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class ActuatorConfig {

    @Bean
    public InfoEndpoint infoEndpoint(List<InfoContributor> infoContributors) {
        return new InfoEndpoint(infoContributors);
    }
}
