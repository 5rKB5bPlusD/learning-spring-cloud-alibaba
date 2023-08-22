package com.zxk.springcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/get")
    public String getProduct() {
        Map<String, String> map = new HashMap<String, String>() {{
            put("id", "01");
        }};
        String res = restTemplate.getForObject("http://localhost:8081/provider/get/{id}", String.class, map);
        return res;
    }
}
