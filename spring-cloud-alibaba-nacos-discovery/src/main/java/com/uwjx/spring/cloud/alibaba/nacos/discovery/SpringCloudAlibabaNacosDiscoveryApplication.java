package com.uwjx.spring.cloud.alibaba.nacos.discovery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringCloudAlibabaNacosDiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudAlibabaNacosDiscoveryApplication.class, args);
    }

}
