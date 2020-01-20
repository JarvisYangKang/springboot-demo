package com.jarvis.demo.util;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
public class ResponseFactory {

    public static Response success() {
        return new Response<>(Constants.SUCCESS_CODE, "成功");
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(Constants.SUCCESS_CODE, "成功", data);
    }

    public static <T> Response<T> error() {
        return error(Constants.ERROR_CODE, "请求失败");
    }

    public static <T> Response<T> error(int code, String message) {
        return new Response<>(code, message);
    }

}
