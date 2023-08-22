package com.zxk.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zxk.springcloud.model.Product;
import com.zxk.springcloud.model.ResultTemplate;
import com.zxk.springcloud.service.ProviderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/provider")
@RefreshScope
public class ProviderController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${server.port}")
    private String port;

    @Value("${user.name}")
    private String username;

    @Value("${user.address}")
    private String address;

    private final AtomicInteger times = new AtomicInteger();

    @Autowired
    private ProviderService providerService;

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping("/get/{id}")
    @SentinelResource(value = "getProduct", blockHandler = "getProductBlock")
    public ResultTemplate<Product> getProduct(@PathVariable("id") int id) {
        String str = applicationName + ": " + id + ", server port: " + port;
        System.out.println(str);
        System.out.println(times.incrementAndGet());
        System.out.println(username);
        System.out.println(address);
        return ResultTemplate.success(providerService.getProduct(new Product().setId(id)));
    }

    public ResultTemplate<Product> getProductBlock(int id, BlockException ex) {
        logger.error("id: {} getProductBlock error: ", id, ex);
        return ResultTemplate.error(null);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    @SentinelResource(value = "updateProduct", blockHandler = "updateProductBlock")
    public ResultTemplate<Product> updateProduct(@RequestBody Product product) {
        return ResultTemplate.success(providerService.updateProduct(product));
    }

    public ResultTemplate<Product> updateProductBlock(Product product, BlockException ex) {
        logger.error("product: {} updateProductBlock error: ", product, ex);
        return ResultTemplate.error(null);
    }
}
