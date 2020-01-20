package com.jarvis.demo.dao;

import com.jarvis.demo.model.entity.City;
import com.jarvis.demo.model.entity.Country;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
public interface CityDao {

    City getCity(int cityId);

    Country getCountry(String code);
}
