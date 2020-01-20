package com.jarvis.demo.common.exception;

/**
 * @author yangkang
 * @version 2020年01月19日
 * @since
 */
public class MyException extends RuntimeException {

    public MyException(String message, Throwable e){
        super(message, e);
    }

    public MyException(String message){
        super(message);
    }

}
