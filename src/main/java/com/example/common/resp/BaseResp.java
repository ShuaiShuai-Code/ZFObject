package com.example.common.resp;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BaseResp<T> {

    private Integer code;
    private String msg;

    private T data;

    public BaseResp(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
