package com.zxk.springcloud.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.zxk.springcloud.dao.ConsumerMapper;
import com.zxk.springcloud.model.Consumer;
import com.zxk.springcloud.model.Product;
import com.zxk.springcloud.model.ResultTemplate;
import com.zxk.springcloud.provider.service.FeignProviderService;
import com.zxk.springcloud.service.ConsumerService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {

    @Autowired
    private ConsumerMapper consumerMapper;

    @Autowired
    private FeignProviderService feignProviderService;

    @Override
    public void saveConsumer(Consumer consumer) {
        consumerMapper.saveConsumer(consumer);
    }

    @Override
    public void updateConsumer(Consumer consumer) {
        consumerMapper.updateConsumer(consumer);
    }

    @Override
    @GlobalTransactional
    public ResultTemplate<JSONObject> buyProduct(Consumer consumer) {
        Consumer before = consumerMapper.getConsumer(consumer);
        if (before.getMoney() < consumer.getMoney()) {
            throw new RuntimeException("钱不够了");
        }
        before.setMoney(before.getMoney() - consumer.getMoney());
        consumerMapper.updateConsumer(before);

        Product product = new Product().setId(1).setProductName("毛巾").setProductNum(1);
        ResultTemplate<Product> resultTemplate = feignProviderService.updateProduct(product);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("consumer", before);
        jsonObject.put("provider", resultTemplate.getData());

        return ResultTemplate.success(jsonObject);
    }
}
