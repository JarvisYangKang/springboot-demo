package com.jarvis.demo.common.datasource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author yangkang
 * @version 2020年01月19日
 * @since
 */
@Aspect
@Order(-1)
@Component
public class DynamicDataSourceAspect {

    /**
     * @within(注解) 类内的所有方法
     * @annotation 被注解的
     */
    @Pointcut("@within(DS)|| @annotation(DS))")//得到的joinPoint都是方法
    public void pointcut() {
    }

    @Around("pointcut()")
    public Object enhance(ProceedingJoinPoint joinPoint) throws Throwable {
        Object proceed;

        MethodSignature sign = (MethodSignature) joinPoint.getSignature();
        Method method = sign.getMethod();

        DS methodAnnotation = method.getAnnotation(DS.class);//找到方法上的注解
        String dataSourceName = null;
        if (methodAnnotation != null) {
            dataSourceName = methodAnnotation.value();
        } else {
            DS classAnnotation = method.getDeclaringClass().getAnnotation(DS.class);//找到方法所在类上的注解
            if (classAnnotation != null) {
                dataSourceName = classAnnotation.value();
            }
        }

        if(dataSourceName != null){
            DynamicRoutingDataSource.setDataSourceKey(dataSourceName);
        }

        try {
            System.out.println("beforeProceed");
            proceed = joinPoint.proceed();//执行实际的切点方法;执行之前会触发@Before
            System.out.println("afterProceed");
        } catch (Throwable e) {
            throw e;
        } finally {
            DynamicRoutingDataSource.clear();
        }

        return proceed;
    }

    @Before("pointcut()")
    public void before(){
        System.out.println("before");
    }

    @After("pointcut()")
    public void after(){
        System.out.println("after");
    }

    //@Around: beforeProceed > before > Proceed > after > 异常 > afterProceed
}
