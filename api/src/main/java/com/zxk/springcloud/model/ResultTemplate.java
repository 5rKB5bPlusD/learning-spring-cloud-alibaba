package com.zxk.springcloud.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@NoArgsConstructor
@Accessors(chain = true)
public class ResultTemplate<T> implements Serializable {

    private Integer code;

    private String msg;

    private T data;

    public static <T> ResultTemplate<T> success(T data) {
        return ResultTemplate.success("success", (T) data);
    }

    public static <T> ResultTemplate<T> success(String msg, T data) {
        return new ResultTemplate<T>().setCode(200).setMsg(msg).setData((T) data);
    }

    public static <T> ResultTemplate<T> error(T data) {
        return ResultTemplate.error("error", (T) data);
    }

    public static <T> ResultTemplate<T> error(String msg, T data) {
        return new ResultTemplate<T>().setCode(500).setMsg(msg).setData((T) data);
    }
}
