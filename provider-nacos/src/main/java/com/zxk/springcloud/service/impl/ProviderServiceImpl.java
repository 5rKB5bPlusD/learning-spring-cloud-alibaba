package com.zxk.springcloud.service.impl;

import com.zxk.springcloud.dao.ProductMapper;
import com.zxk.springcloud.model.Product;
import com.zxk.springcloud.service.ProviderService;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Tags;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProductMapper productMapper;

    @Override
    public Product getProduct(Product product) {
        return productMapper.getProduct(product);
    }

    @Override
    @Trace
    @Tags(value = {@Tag(key = "updateProduct", value = "arg[0]"),
            @Tag(key = "updateProduct", value = "returnedObj")})
    public Product updateProduct(Product product) {
        Product before = productMapper.getProduct(product);
        if (before.getProductNum() < product.getProductNum()) {
            throw new RuntimeException("库存不足");
        }
        before.setProductNum(before.getProductNum() - product.getProductNum());
        productMapper.updateProduct(before);
        return before;
    }
}
