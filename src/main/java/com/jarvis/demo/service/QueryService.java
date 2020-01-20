package com.jarvis.demo.service;

import com.jarvis.demo.model.vo.CityVO;
import com.jarvis.demo.model.vo.CountryVO;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
public interface QueryService {
    
    CityVO getCity(int cityId);

    CountryVO getCountry(String code);
}
