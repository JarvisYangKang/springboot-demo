package com.jarvis.demo.mapper;

import com.jarvis.demo.model.entity.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author yangkang
 * @version 2020年01月20日
 * @since
 */
@Repository
@Mapper
public interface CityMapper {

    City getCity(@Param("cityId") int cityId);
}
