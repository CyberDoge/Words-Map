package org.cd.project.words_map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@ComponentScan("org.cd.project.words_map")
@SpringBootApplication
public class WordsMapApplication {

    public static void main(String[] args) {
        SpringApplication.run(WordsMapApplication.class, args);
    }
}
