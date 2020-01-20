package com.jarvis.demo.util;

import lombok.Getter;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
@Getter
public class Response<T> {
    private int code;
    private String message;
    private T data;

    public Response(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Response(int code, String message){
        this.code = code;
        this.message = message;
    }

}
