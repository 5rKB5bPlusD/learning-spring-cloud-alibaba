package com.zxk.springcloud.mapper;

import com.zxk.springcloud.model.Consumer;
import com.zxk.springcloud.model.ConsumerDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ConsumerMapper {

//    ConsumerMapper INSTANCE = Mappers.getMapper(ConsumerMapper.class);

    ConsumerDTO consumerToDto(Consumer consumer);
}
