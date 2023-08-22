package com.zxk.springcloud.dao;

import com.zxk.springcloud.model.Consumer;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ConsumerMapper {

    Consumer getConsumer(Consumer consumer);

    void saveConsumer(Consumer consumer);

    void updateConsumer(Consumer consumer);
}
