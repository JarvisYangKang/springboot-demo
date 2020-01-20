package com.jarvis.demo.service.impl;

import com.jarvis.demo.dao.CityDao;
import com.jarvis.demo.model.entity.City;
import com.jarvis.demo.model.entity.Country;
import com.jarvis.demo.model.vo.CityVO;
import com.jarvis.demo.model.vo.CountryVO;
import com.jarvis.demo.service.QueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
@Service
public class QueryServiceImpl implements QueryService {

    @Autowired
    private CityDao cityDao;

    @Override
    public CityVO getCity(int cityId) {
        City city = cityDao.getCity(cityId);
        CityVO cityVO = new CityVO();
        cityVO.setName("(" + city.getCountryCode() + ")" + city.getName());
        cityVO.setPopulation(city.getPopulation());

        return cityVO;
    }

    @Override
    public CountryVO getCountry(String code) {
        Country country = cityDao.getCountry(code);
        CountryVO countryVO = new CountryVO();
        countryVO.setName(country.getName() + ":" + country.getContinent() + ":" + country.getRegion());

        return countryVO;
    }

}
