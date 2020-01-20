package com.jarvis.demo.common.datasource;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * @author yangkang
 * @version 2020年01月19日
 * @since
 */
public class DynamicRoutingDataSource extends AbstractRoutingDataSource {

    public static ThreadLocal<String> context = new ThreadLocal<>();

    public static void setDataSourceKey(String key){
        context.set(key);
    }

    public static void clear(){
        context.remove();
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return context.get();
    }

}
