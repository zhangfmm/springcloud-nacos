package com.zfm.friend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringcloudFriendApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudFriendApplication.class, args);
    }

}
