package com.zxk.springcloud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ConsumerDTO implements Serializable {

    private String id;

    private String username;

    private String money;
}
