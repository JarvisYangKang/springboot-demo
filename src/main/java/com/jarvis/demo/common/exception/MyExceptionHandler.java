package com.jarvis.demo.common.exception;

import com.jarvis.demo.util.Constants;
import com.jarvis.demo.util.Response;
import com.jarvis.demo.util.ResponseFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.servlet.http.HttpServletRequest;

/**
 * SpringMVC 全局异常拦截
 * @author yangkang
 * @version 2020年01月19日
 * @since
 */
@Slf4j
@ControllerAdvice
public class MyExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response catchException(HttpServletRequest request, Exception exception){
        String message = request.getRequestURI() + ",(1)请求异常:" + exception.getMessage();
        log.error(message, exception);
        return ResponseFactory.error(Constants.ERROR_CODE, message);
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public Response myException(HttpServletRequest request, MyException exception){
        String message = request.getRequestURI() + ",(1)请求异常:" + exception.getMessage();
        log.error(message, exception);
        return ResponseFactory.error(Constants.ERROR_CODE, request.getRequestURI() + ",(2)请求异常:" + exception.getMessage());
    }

}
