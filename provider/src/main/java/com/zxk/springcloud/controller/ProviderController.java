package com.zxk.springcloud.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/provider")
public class ProviderController {

    @RequestMapping("/get/{id}")
    public String getProduct(@PathVariable("id") String id) {
        String str = "test: " + id;
        System.out.println(str);
        return str;
    }
}
