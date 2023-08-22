package com.zxk.springcloud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class Product implements Serializable {

    private Integer id;

    private String productName;

    private Float productPrice;

    private Integer productNum;
}
