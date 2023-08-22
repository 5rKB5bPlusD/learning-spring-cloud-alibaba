package com.zxk.springcloud.service;

import com.zxk.springcloud.model.Product;

public interface ProviderService {

    Product getProduct(Product product);

    Product updateProduct(Product product);
}
