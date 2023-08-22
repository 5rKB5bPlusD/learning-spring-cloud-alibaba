package com.zxk.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    private final AtomicInteger times = new AtomicInteger();

    @RequestMapping("/get/{id}")
    public String getProduct(@PathVariable("id") String id) {
        String str = applicationName + ": " + id + ", server port: " + port;
        System.out.println(str);
        System.out.println(times.incrementAndGet());
        return str;
    }
}
