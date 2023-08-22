package com.zxk.springcloud.dao;

import com.zxk.springcloud.model.Product;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductMapper {

    Product getProduct(Product product);

    void updateProduct(Product product);
}
