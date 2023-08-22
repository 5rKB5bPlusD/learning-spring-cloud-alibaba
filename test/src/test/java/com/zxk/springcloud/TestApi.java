package com.zxk.springcloud;

import com.alibaba.fastjson.JSONObject;
import com.zxk.springcloud.mapper.ConsumerMapper;
import com.zxk.springcloud.model.Consumer;
import com.zxk.springcloud.model.ConsumerDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TestApi {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Test
    public void testApi() {
        Consumer consumer = new Consumer().setId(1).setUsername("test").setMoney(100F);
//        ConsumerDTO consumerDTO = ConsumerMapper.INSTANCE.consumerToDto(consumer);
        ConsumerDTO consumerDTO = consumerMapper.consumerToDto(consumer);
        System.out.println(JSONObject.toJSONString(consumerDTO));
    }
}
