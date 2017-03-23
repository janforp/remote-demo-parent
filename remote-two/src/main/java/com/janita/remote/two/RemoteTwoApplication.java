package com.janita.remote.two;

import com.janita.remote.two.config.RemoteConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * Created by Janita on 2017-03-23 10:43
 */
@SpringBootApplication
@EnableConfigurationProperties({RemoteConfig.class})
public class RemoteTwoApplication {
    public static void main(String[] args) {
        SpringApplication.run(RemoteTwoApplication.class, args);
    }
    
}
