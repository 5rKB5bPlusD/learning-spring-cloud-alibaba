package com.zxk.springcloud.service;

import com.alibaba.fastjson.JSONObject;
import com.zxk.springcloud.model.Consumer;
import com.zxk.springcloud.model.ResultTemplate;

public interface ConsumerService {

    void saveConsumer(Consumer consumer);

    void updateConsumer(Consumer consumer);

    ResultTemplate<JSONObject> buyProduct(Consumer consumer);
}
