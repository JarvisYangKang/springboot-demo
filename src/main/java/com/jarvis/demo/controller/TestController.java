package com.jarvis.demo.controller;

import com.jarvis.demo.common.exception.MyException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
@RestController
@RequestMapping("test")
public class TestController {

    @GetMapping("myException")
    public String myException(){
        throw new MyException("myException");
    }

    @GetMapping("exception")
    public String exception() throws Exception{
        throw new Exception("exception");
    }
}
