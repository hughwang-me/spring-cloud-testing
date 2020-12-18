package com.uwjx.springcloud.alibaba.nacos.client.controller;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/18 18:46
 */
@RestController
@RequestMapping(value = "client")
@Slf4j
public class ClientController {

    private final static String DISCOVERY_SERVICE_ID = "nacos-discovery";

    @Autowired
    LoadBalancerClient loadBalancerClient;

    @Autowired
    RestTemplate restTemplate;


    @GetMapping(value = "get")
    public String get() {
        ServiceInstance serviceInstance = loadBalancerClient.choose(DISCOVERY_SERVICE_ID);
        log.warn("serviceInstance info : {}", JSON.toJSONString(serviceInstance));
        String url1 = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/test/test1";
        log.warn("url1 -> {}", url1);

        String url2 = "http://" + DISCOVERY_SERVICE_ID + "/test/test1";
        log.warn("url2 -> {}", url2);
        String result = restTemplate.getForObject(url1, String.class);
        log.warn("result : {}", result);
        return result;
    }

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }
}
