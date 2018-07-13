package org.cd.project.words_map.config;

import org.cd.project.words_map.service.MapBuilder;
import org.cd.project.words_map.service.MapBuilderImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("org.cd.project.words_map")
public class AppConfig {
    @Bean
    public MapBuilder mapBuilder() {
        return new MapBuilderImpl();
    }
}
