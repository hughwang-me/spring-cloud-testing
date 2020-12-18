package com.uwjx.spring.cloud.alibaba.nacos.discovery.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Wang Huan
 * @author 18501667737@163.com
 * @date 2020/12/18 18:38
 */
@RestController
@RequestMapping(value = "test")
@Slf4j
public class TestController {

    @GetMapping(value = "test1")
    public String test1(){
        log.warn("discover test test1 invoked!!!");
        return "test1 success";
    }
}
