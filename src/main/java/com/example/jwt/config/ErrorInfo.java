package com.example.jwt.config;

import lombok.Data;

/**
 * ErrorInfo
 *
 * @author lijiehua
 * @date 2018-06-12
 */
@Data
public class ErrorInfo<T> {

    public static final Integer OK = 0;
    public static final Integer ERROR = 100;

    private Integer code;
    private String message;
    private String url;
    private T data;
}
