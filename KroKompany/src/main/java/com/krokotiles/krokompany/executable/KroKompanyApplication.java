package com.krokotiles.krokompany.executable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication(scanBasePackages = {"com.krokotiles.krokompany"})
@EntityScan("com.krokotiles.krokompany")
@EnableJpaRepositories("com.krokotiles.krokompany.repository")
@EnableConfigurationProperties
@EnableCaching
@EnableScheduling
public class KroKompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(KroKompanyApplication.class, args);
    }
}