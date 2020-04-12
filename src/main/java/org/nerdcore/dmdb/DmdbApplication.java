package org.nerdcore.dmdb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaAuditing
@EnableJpaRepositories("org.nerdcore.dmdb.repository")
public class DmdbApplication {

    public static void main(String[] args) {
        SpringApplication.run(DmdbApplication.class, args);
    }

}
