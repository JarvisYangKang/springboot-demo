package com.jarvis.demo.dao.mysql;

import com.jarvis.demo.common.datasource.DS;
import com.jarvis.demo.dao.CityDao;
import com.jarvis.demo.mapper.CityMapper;
import com.jarvis.demo.mapper.CountryMapper;
import com.jarvis.demo.model.entity.City;
import com.jarvis.demo.model.entity.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
@Service
@ConditionalOnProperty(name = "datasource.type", havingValue = "mysql")
public class CityMsDaoImpl implements CityDao {

    @Autowired
    private CityMapper cityMapper;

    @Autowired
    private CountryMapper countryMapper;

    @DS("a")
    @Override
    public City getCity(int cityId) {
        return cityMapper.getCity(cityId);
    }

    @DS("b")
    @Override
    public Country getCountry(String code) {
        return countryMapper.getCountry(code);
    }

}
