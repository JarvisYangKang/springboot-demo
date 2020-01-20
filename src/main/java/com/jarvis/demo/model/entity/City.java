package com.jarvis.demo.model.entity;

import lombok.Data;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
@Data
public class City {
    private Integer id;
    private String name;
    private String countryCode;
    private Long population;
}
