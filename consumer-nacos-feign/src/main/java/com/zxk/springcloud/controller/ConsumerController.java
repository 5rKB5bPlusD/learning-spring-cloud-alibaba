package com.zxk.springcloud.controller;

import com.alibaba.fastjson.JSONObject;
import com.zxk.springcloud.model.Consumer;
import com.zxk.springcloud.model.ResultTemplate;
import com.zxk.springcloud.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consumer")
public class ConsumerController {

    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("/buy")
    public ResultTemplate<JSONObject> buyProduct() {
        Consumer consumer = new Consumer().setId(1).setUsername("test01").setMoney(10F);
        try {
            return consumerService.buyProduct(consumer);
        } catch (RuntimeException ex) {
            ex.printStackTrace();
        }
        return ResultTemplate.error(null);
    }
}
