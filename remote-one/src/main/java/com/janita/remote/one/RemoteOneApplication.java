package com.janita.remote.one;

import com.janita.remote.one.config.RemoteConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by Janita on 2017-03-23 09:06
 */
@SpringBootApplication
@EnableConfigurationProperties({RemoteConfig.class})
public class RemoteOneApplication {

    public static void main(String[] args) {
        SpringApplication.run(RemoteOneApplication.class, args);
    }
}