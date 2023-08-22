package com.zxk.springcloud.provider.service;

import com.zxk.springcloud.model.Product;
import com.zxk.springcloud.model.ResultTemplate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "provider-nacos", path = "/provider")
public interface FeignProviderService {

    @RequestMapping("/get/{id}")
    ResultTemplate<Product> getProduct(@PathVariable("id") String id);

    @RequestMapping(value = "/update", method = RequestMethod.PUT)
    ResultTemplate<Product> updateProduct(@RequestBody Product product);
}
