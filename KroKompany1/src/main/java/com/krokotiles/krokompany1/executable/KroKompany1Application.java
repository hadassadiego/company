package com.krokotiles.krokompany1.executable;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableConfigurationProperties
@EnableCaching
@EnableScheduling
public class KroKompany1Application {

    public static void main(String[] args) {
        SpringApplication.run(KroKompany1Application.class, args);
    }

}
